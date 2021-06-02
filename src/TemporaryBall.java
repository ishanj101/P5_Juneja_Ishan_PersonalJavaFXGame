import javafx.scene.image.Image;

public class TemporaryBall extends Ball {
	double maxDX = 5;
	double maxDY = -2.5;
	
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
			//System.out.println("1");
			double x = getOneIntersectingObject(Paddle.class).getX();
			double y = getOneIntersectingObject(Paddle.class).getY();
			Paddle paddle = getOneIntersectingObject(Paddle.class);

			if((paddle.getDx()==0 || paddle.getPos() == paddle.getX()) && getX() >= x && getX() <= x + getOneIntersectingObject(Paddle.class).getWidth()){
				dy = -dy;
				if(dx < 0 && dx < -maxDX) {
					dx = dx + 0.5;
		
				}else {
					dx = dx - 0.5;
				}
				if(dy < 0 && dy < -maxDY) {
					dy = dy + 0.25;
		
				}else {
					dy = dy - 0.25;
				}
				this.setY(this.getY()-2);
			}
			if(paddle.getDx()!=0 ){
				
				if((paddle.getDx() < 0 && ( getX() > paddle.getPos()|| getX() < (paddle.getPos() + paddle.getWidth()/3)))){ //getX() < paddle.getPos() + 2*(paddle.getWidth()/8)
					//System.out.println("Checking 1");
					dx = -Math.abs(dx)-0.5;
					dy = -dy;
					if(dy > 0) {
						dy = dy + 0.26;
					}else {
						dy = dy - 0.26;
					}
					this.setY(this.getY()-1);
				}
				else if(getX() <= paddle.getPos() + (paddle.getWidth()*2)/3){
					dy = - dy;
					this.setY(this.getY()-1);
				}
				else {
					dx = Math.abs(dx)+0.5;
					
					dy = -dy;
					this.setY(this.getY()-1);
				}
			}
			
			if(true){
				if(getX() < paddle.getPos() + (paddle.getWidth()/8) || getX() >  paddle.getPos() + 7*(paddle.getWidth()/8)  ) {
					maxDX += 0.1;
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
					if(dy > 0) {
						dy = dy + 0.25;
					}else {
						dy = dy - 0.25;
					}
					dy = -maxDY*1.25;
					maxDY += 0.1;
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
