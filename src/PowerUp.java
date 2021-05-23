import java.util.List;
import java.util.Random;

import javafx.scene.Node;
import javafx.scene.image.Image;

public class PowerUp extends Actor{
	
	private double dx;
	private double dy;
	private int type;
	/*
	public PowerUp(boolean t) {
		Random rand = new Random();
		double speed = rand.nextInt(3)+3;
		int category = rand.nextInt(3);
		int xPos = rand.nextInt(500);
		String path = getClass().getClassLoader().getResource("resources/power1.png").toString();
		Image img = new Image(path,35, 35, true,false);
		this.setImage(img);
	
		dx = 0;
		dy = 3;
		type = category;
		this.setX(xPos);
		this.setY(0);
		
		
	}
	
	public PowerUp() {
		Random rand = new Random();
		double speed = rand.nextInt(3)+3;
		int category = rand.nextInt(3);
		int xPos = rand.nextInt(500);
	

	
		dx = 0;
		dy = 3;
		type = category;
		this.setX(xPos);
		this.setY(speed);
		
		
	}
	
	*/
	
	public PowerUp() {
		String path = getClass().getClassLoader().getResource("resources/power1.png").toString();
		Image img = new Image(path,30, 30, true,false);
		Random rand = new Random();
		int cond = rand.nextInt(3);
		this.setImage(img);
		cond = 2;
		type = cond;
		dx = 0;
		dy = 2;
	}


	@Override
	public void act(long now) {
		
		//paddle intersection
		if(getOneIntersectingObject(Paddle.class)!=null){
			if(type == 0) { //add a ball
				TemporaryBall ball = new TemporaryBall();
		        ball.setX(250);
		        ball.setY(250);
		        this.getWorld().add(ball);
				System.out.println("Balls Shall Be Added");
				this.getWorld().remove(this);
			}
			if(type == 1) { //paddle size
				for(Node actor: this.getWorld().getChildren()) {
					if(actor instanceof Paddle) {
						((Paddle) actor).increase();
						((Paddle)actor).setBig(true);
					}
				}
			}
			if(type == 2) {
				for(Node actor: this.getWorld().getChildren()) {
					if(actor instanceof Ball && !(actor instanceof TemporaryBall)) {
						double x = ((Ball) actor).getX();
						double y = ((Ball) actor).getY();
						((Ball) actor).getWorld().remove((Ball)actor);
						FieryBall ball2 = new FieryBall();
					
						ball2.setX(x);
						ball2.setY(y);
						this.getWorld().add(ball2);
					}
				}
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
		
		if(getY() + getHeight() >= getWorld().getHeight()) {
			this.getWorld().remove(this);
		}

		if(getHeight() == getY()){
			this.getWorld().remove(this);
		}

		
		
	
		
		
		
		
		
		
	}

}
