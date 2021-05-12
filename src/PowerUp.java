import javafx.scene.image.Image;

public class PowerUp extends Actor{
	
	private double dx;
	private double dy;
	private int type;
	
	public PowerUp() {
		String path = getClass().getClassLoader().getResource("resources/power1.png").toString();
		Image img = new Image(path,30, 30, true,false);
		
		this.setImage(img);
		type = 1;
		dx = 0;
		dy = 2;
	}
	
	public PowerUp(int category, int y, int startPos) {
		//1 adds more balls
		if(category == 1) {
			String path = getClass().getClassLoader().getResource("resources/power1.png").toString();
			Image img = new Image(path);
			this.setImage(img);
			
			
		}
		type = category;
		dx = 0;
		dy = y;
		
	}


	@Override
	public void act(long now) {
		
		//World Boundaries
		this.move(dx, dy);
		if(getX() <= 0) {
			dx = -dx;
		}
		if(getX() + getWidth() >= getWorld().getWidth()) {
			dx = -dx;
		}
		
		if(getY() + getHeight() >= getWorld().getHeight()) {
			this.getWorld().remove(this);
		}

		if(getHeight() == getY()){
			this.getWorld().remove(this);
		}

		
		
	
		
		//paddle intersection
		
		/*
		if(getOneIntersectingObject(Paddle.class)!=null){
			if(type == 1) {
				System.out.println("Balls Shall Be Added");
			}
		}
		*/
	}

}
