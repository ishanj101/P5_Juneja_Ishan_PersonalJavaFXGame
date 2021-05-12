import javafx.scene.image.Image;

public class TemporaryBall extends Ball {
	
	public TemporaryBall () {
		String path = getClass().getClassLoader().getResource("resources/ball2.png").toString();
		Image img = new Image(path,20, 20, true,false);
		this.setImage(img);
		dx = 4;
		dy = -2.25;
	}
	
	private double dx;
	private double dy;
	
	@Override
	public void act(long now) {
		conditions();
		

		//World Boundaries
		this.move(dx, dy);
		if(getX() <= 0) {
			dx = -dx;
		}
		if(getX() + getWidth() >= getWorld().getWidth()) {
			dx = -dx;
		}
		
		if(getY() <= 0) {
			dy = -dy;
		}
		if(getY() + getHeight() >= getWorld().getHeight()) {
			this.getWorld().remove(this);
		}
		
	}

}
