import javafx.scene.image.Image;

public class Enemy extends Actor{
	
	private double dx;
	private double dy;
	private double bottomCounter = 0;
	
	public Enemy() {
		String path = getClass().getClassLoader().getResource("resources/evilBall.png.jpeg").toString();
		Image img = new Image(path,50, 50, true,false);
		this.setImage(img);
		dx = 5;
		dy = -3;
	}


	public void conditions() {
		//normal brick intersection
		if(bottomCounter >= 3) {
			this.getWorld().getChildren().remove(this);
		}
		if(getOneIntersectingObject(Brick.class)!=null){
			Brick brick = getOneIntersectingObject(Brick.class);
			double x = getOneIntersectingObject(Brick.class).getX();
			double y = getOneIntersectingObject(Brick.class).getY();
			if(getX() >= x && getX() <= x + getOneIntersectingObject(Brick.class).getWidth()){
				dy = -dy;
				this.setY(this.getY()-1);
			}
			else if(getY() >= y && getY() <= y + getOneIntersectingObject(Brick.class).getHeight()){
				dx = -dx;
			}
			else{
				dy = -dy;
				this.setY(this.getY()-1);
				dx = -dx;
			}
			((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getScoreCount()+100);
			((BallWorld)getWorld()).getScore().updateDisplay();
			brick.strengthen();
			
			
		}

		//paddle intersection
		if(getOneIntersectingObject(Ball.class)!=null){
			this.getWorld().getChildren().remove(this);
		}
		if(getOneIntersectingObject(Paddle.class)!=null){
			((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getScoreCount()-500);
			((BallWorld)getWorld()).getScore().updateDisplay();
			this.getWorld().getChildren().remove(this);
			
		}else {
			//bottom world scoring
			if(this.getWorld().getHeight()-getHeight() <= getY()){
				bottomCounter++;
			}
		}
				
			
	}
	@Override
	public void act(long now) {
		
		conditions();
	
		
		//World Boundaries
		this.move(dx, 0);
		this.move(0, dy);
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
			dy = -dy;
		}
		
	}

}
