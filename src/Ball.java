import javafx.scene.image.Image;

public class Ball extends Actor{
	
	private double dx;
	private double dy;
	private double maxDX;
	private double maxDY;
	
	public Ball() {
		String path = getClass().getClassLoader().getResource("resources/ball.png").toString();
		Image img = new Image(path);
		this.setImage(img);
		dx = 5;
		dy = -3;
		
		maxDX = 4+0.5;
		maxDY = 2.75+0.25;
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
					if(paddle.getDx()!=0 ){
						System.out.println("Checking 1");
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
					
					if(true){
						System.out.println("Checkin 2");
						if(getX() < paddle.getPos() + (paddle.getWidth()/8) || getX() >  paddle.getPos() + 7*(paddle.getWidth()/8)  ) {
							if(dx < 0) {
								dx = -maxDX;
					
							}else {
								dx = maxDX;
							}
							dy = -maxDY*0.8;
							
						}else if(getX() < paddle.getPos() + 2*(paddle.getWidth()/8) || getX() >  paddle.getPos() + 6*(paddle.getWidth()/8)) {
							if(dx < 0) {
								dx = -maxDX*0.85;
					
							}else {
								dx = maxDX*0.85;
							}
							
							dy = -maxDY*1;
							
							
						}else if(getX() < paddle.getPos() + 3*(paddle.getWidth()/8) || getX() >  paddle.getPos() + 5*(paddle.getWidth()/8)) {
							if(dx < 0) {
								dx = -maxDX*0.7;
					
							}else {
								dx = maxDX*0.7;
							}
							dy = -maxDY*1.15;
						}else {
							if(dx < 0) {
								dx = -maxDX*0.5;
					
							}else {
								dx = maxDX*0.5;
							}
							dy = -maxDY*1.25;
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
