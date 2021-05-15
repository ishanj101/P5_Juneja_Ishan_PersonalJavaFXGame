import java.util.Random;

import javafx.scene.Node;

public class BallWorld extends World{

	private Score score;
	private long oldTime = 1;

	public BallWorld(){
		score = new Score();
		score.setX(30);
		score.setY(30);
		this.getChildren().add(score);
		addPower();
		
	}
	public void addPower() {
		/*
		Random rand = new Random();
		int speed = rand.nextInt(2)+3;
		int type = rand.nextInt(1);
		int xPos = rand.nextInt(500);
		
		PowerUp p1= new PowerUp(type,speed);
	    p1.setX(xPos);
	    p1.setY(0);
	    
	*/
		Random rand = new Random();
		int xPos = rand.nextInt(500);
		PowerUp p1= new PowerUp();
        p1.setX(xPos);
        p1.setY(0);
	    this.getChildren().add(p1);
	    System.out.println("aiuneounuowegnouwegiwe");
		
	}
	@Override
	public void act(long now) {
		
		
		Random rand = new Random();
		int cond = rand.nextInt(3);
	    
		if(cond == 1 ) {
			if(oldTime % 600 == 0) {
				addPower();
				oldTime = 1;
				
			}
		
		}else if(cond == 2 || cond == 1) {
			if(oldTime % 1300 == 0) {
				addPower();
				oldTime = 1;
			}
		}else if(cond == 0) {
			if(oldTime % 1000 == 0) {
				addPower();
				oldTime = 1;
			}
		}else if(oldTime == 1800) {
			addPower();
			oldTime = 1;
			System.out.println("Aaaaaaa");
		}
		oldTime++;
		
		if(oldTime == 1000 - (cond*100)) {
			for(Node actor: this.getChildren()) {
				if(actor instanceof Paddle) {
					if(((Paddle) actor).isBig()){
						((Paddle) actor).decrease();
						((Paddle)actor).setBig(false);
					}
				}
				if(actor instanceof FieryBall) {
					double x = ((FieryBall) actor).getX();
					double y = ((FieryBall) actor).getY();
					((FieryBall) actor).getWorld().remove((FieryBall)actor);
					Ball ball2 = new Ball();
					ball2.setX(x);
					ball2.setY(y);
					this.getChildren().add(ball2);
				}
			}
		}
	}
	

	public Score getScore(){
		return score;
	}
}
