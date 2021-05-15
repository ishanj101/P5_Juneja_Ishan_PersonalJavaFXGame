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
		
		if(getOneIntersectingObject(Brick.class)!=null){
			Brick brick = getOneIntersectingObject(Brick.class);
			double x = getOneIntersectingObject(Brick.class).getX();
			double y = getOneIntersectingObject(Brick.class).getY();
			if(getX() >= x && getX() <= x + getOneIntersectingObject(Brick.class).getWidth()){
				dy = -dy;
			}
			else if(getY() >= y && getY() <= y + getOneIntersectingObject(Brick.class).getHeight()){
				dx = -dx;
			}
			else{
				dy = -dy;
				dx = -dx;
			}
			((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getScoreCount()+100);
			((BallWorld)getWorld()).getScore().updateDisplay();
			brick.onHit();
			
		}

		//paddle intersection
		
		if(getOneIntersectingObject(Paddle.class)!=null){
			System.out.println("1");
			double x = getOneIntersectingObject(Paddle.class).getX();
			double y = getOneIntersectingObject(Paddle.class).getY();
			Paddle paddle = getOneIntersectingObject(Paddle.class);

			if((paddle.getDx()==0 || paddle.getPos() == paddle.getX()) && getX() >= x && getX() <= x + getOneIntersectingObject(Paddle.class).getWidth()){
				dy = -dy;
			}
			if(paddle.getDx()!=0 || paddle.getPos() != paddle.getX()){
				System.out.println("HI");
				if((paddle.getDx() < 0 || paddle.getPos() > paddle.getX()) &&
						getX() <= paddle.getX() + paddle.getWidth()/3){
					dx = -Math.abs(dx);
					dy = -dy;
					this.setY(this.getY()-1);
				}
				else if(getX() <= paddle.getX() + (paddle.getWidth()*2)/3){
					dy = - dy;
					this.setY(this.getY()-1);
				}
				else if(((paddle.getDx() > 0 || paddle.getPos() < paddle.getX())) &&
				getX() >= paddle.getX() + (paddle.getWidth()*2)/3){
					dx = Math.abs(dx);
					dy = -dy;
					this.setY(this.getY()-1);
				}
			}
			
		}else {
			//bottom world scoring
			if(this.getWorld().getHeight()-getHeight() <= getY()){
				this.getWorld().remove(this);
			}
		}
		
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
		
		
	}

}
