import java.util.Random;

import javafx.scene.Node;
import javafx.scene.image.Image;

public class Enemy extends Actor{
	
	private double dx;
	private double dy;
	private double bottomCounter = 0;
	private double movingStyle = 0;
	private double counter = 0;
	private boolean moveWay;
	
	public Enemy() {
		String path = getClass().getClassLoader().getResource("resources/evilBall.png.jpeg").toString();
		Image img = new Image(path,50, 50, true,false);
		this.setImage(img);
		dx = 5;
		dy = -3;
	}
	public Enemy(int style) {
		String path = getClass().getClassLoader().getResource("resources/evilBall.png.jpeg").toString();
		Image img = new Image(path,50, 50, true,false);
		this.setImage(img);
		dx = 5;
		dy = -3;
		movingStyle = style;
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
			Random rand = new Random();
			int cond = rand.nextInt(2);
			if(cond == 0) {
				brick.strengthen();
			}
			
			
		}

		//paddle intersection
		
		if(getOneIntersectingObject(Ball.class)!=null){
			this.getWorld().getChildren().remove(this);
		}
		if(getOneIntersectingObject(Paddle.class)!=null) {
			for(Node actor: this.getWorld().getChildren()) {
				if(actor instanceof Ball && !(actor instanceof TemporaryBall) &&!(actor instanceof FieryBall)) {
					double x = ((Ball) actor).getX();
					double y = ((Ball) actor).getY();
					System.out.println(((Ball) actor).getHeight());
					System.out.println(((Ball) actor).getWidth());
					((Ball) actor).setFitHeight(9);
					((Ball) actor).setFitWidth(9);
				}
			}
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
				bottomCounter++;
			}
		}
				
			
	}
	@Override
	public void act(long now) {
		
		conditions();
	
		
		//World Boundaries
		if(movingStyle == 0) {
			this.move(dx, dy);
		}else {
			Random rand = new Random();
			int i = rand.nextInt(15);
			counter++;
			if(counter == 20) {
				moveWay = (!moveWay);
				counter = 0;
			}
			if(moveWay) {
				this.move(dx*1.15, 0);
			}else {
				this.move(0, dy*2);
			}
			
		}
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
