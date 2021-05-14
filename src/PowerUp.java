import java.util.List;

import javafx.scene.Node;
import javafx.scene.image.Image;

public class PowerUp extends Actor{
	
	private double dx;
	private double dy;
	private int type;
	
	public PowerUp() {
		String path = getClass().getClassLoader().getResource("resources/power1.png").toString();
		Image img = new Image(path,30,30, true,false);
		
		this.setImage(img);
		type = 0;
		dx = 0;
		dy = 2;
	}
	
	public PowerUp(int category, int speed) {
		//1 adds more balls
		
		
		if(category == 0) {
			String path = getClass().getClassLoader().getResource("resources/power1.png").toString();
			Image img = new Image(path,30, 30, true,false);
			this.setImage(img);
		}else if(category ==1) {
			String path = getClass().getClassLoader().getResource("resources/power1.png").toString();
			Image img = new Image(path,30, 30, true,false);
			this.setImage(img);
		}
		type = category;
		dx = 0; dy =speed;
		
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
