import javafx.scene.image.Image;

public class Ball extends Actor{
	
	private double dx;
	private double dy;
	
	public Ball() {
		String path = getClass().getClassLoader().getResource("resources/ball.png").toString();
		Image img = new Image(path);
		this.setImage(img);
		dx = 4;
		dy = -2.75;
	}


	public void conditions() {
		//normal brick intersection
				if(getOneIntersectingObject(Brick.class)!=null){
					this.getWorld().setBricksHit(this.getWorld().getBricksHit()+1);
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
						System.out.println("what");
						((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getScoreCount()-1000);
						((BallWorld)getWorld()).getScore().updateDisplay();
					}
				}
				
			
	}
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
			dy = -dy;
		}
		
	}

}
