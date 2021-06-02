import javafx.scene.image.Image;

public class FieryBall extends Ball{
	
	private double dx;
	private double dy;
	private double maxDX;
	private double maxDY;
	
	public FieryBall() {
		String path = getClass().getClassLoader().getResource("resources/ball3.png.jpg").toString();
		Image img = new Image(path,30, 30, true,false);
		this.setImage(img);
		dx = 4.25;
		dy = -6;
		maxDX = dx * 1.1;
		maxDY = dy * 1.1;
	}

	@Override
	public void act(long now) {
		
	
		if(getOneIntersectingObject(Brick.class)!=null){
			this.getWorld().setBricksHit(this.getWorld().getBricksHit()+1);
			
			Brick brick = getOneIntersectingObject(Brick.class);
			double x = getOneIntersectingObject(Brick.class).getX();
			double y = getOneIntersectingObject(Brick.class).getY();
			if(getX() >= x && getX() <= x + getOneIntersectingObject(Brick.class).getWidth()){
				dy = -dy;
			}
			else{
				dy = -dy;
				dx = -dx;
			}
			((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getScoreCount()+100);
			((BallWorld)getWorld()).getScore().updateDisplay();
			if(brick.getStrength()<=1) {
				this.getWorld().setBrickCount(this.getWorld().getBrickCount()-1);
			}
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
			if(paddle.getDx()!=0){
				System.out.println("Checking 1");
				if((paddle.getDx() < 0 || paddle.getPos() > paddle.getX()) &&
						getX() <= paddle.getX() + paddle.getWidth()/3){
					dx = -Math.abs(dx);
					dy = -dy;
				}
				else if(getX() <= paddle.getX() + (paddle.getWidth()*2)/3){
					dy = - dy;
				}
				else if(((paddle.getDx() > 0 || paddle.getPos() < paddle.getX())) &&
				getX() >= paddle.getX() + (paddle.getWidth()*2)/3){
					dx = Math.abs(dx);
					dy = -dy;
				}
			}
			
		}else {
			//bottom world scoring
			if(this.getWorld().getHeight()-getHeight() <= getY()){
				System.out.println("what");
				((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getScoreCount()-1000);
				((BallWorld)getWorld()).getScore().updateDisplay();
				((BallWorld)getWorld()).setLife(((BallWorld)getWorld()).getLife()-1);
			}
		}
		
		if(getOneIntersectingObject(Brick.class)!=null){
			Brick brick = getOneIntersectingObject(Brick.class);
			
			((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getScoreCount()+100);
			((BallWorld)getWorld()).getScore().updateDisplay();
			
			if(brick.getStrength()<=1) {
				this.getWorld().setBrickCount(this.getWorld().getBrickCount()-1);
			}
			brick.onHit();
			
		}
		
		//World Boundaries
		this.move(dx, dy);
		
		if(getX() <= 0.1) {
			dx = -dx;
			this.setX(0.11);
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
