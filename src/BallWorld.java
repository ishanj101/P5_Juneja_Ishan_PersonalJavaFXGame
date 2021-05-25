import java.util.Random;

import javafx.scene.Node;

public class BallWorld extends World{

	private Score score;
	private long oldTime = 1;
	private long ime = 1;
	int lives = 3;
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
		int cond2 = rand.nextInt(2);
		
	    int xx = rand.nextInt((int) this.getWidth());
	    int yy = rand.nextInt((int) this.getHeight());
	    
		if(this.getBricksHit() != 0 && this.getBricksHit()%8 == 0) {
			int i = rand.nextInt(2);
			Enemy en = new Enemy(cond2);
	        en.setX(xx);
	        en.setY(yy);
	        this.add(en);
	        this.setBricksHit(i);
		}
		if(cond == 1 ) {
			if(oldTime % 600 == 0) {
				addPower();
				oldTime = 1;
				
			}
		
		}else if(cond == 2 || cond == 1) {
			if(oldTime % 900 == 0) {
				addPower();
				oldTime = 1;
			}
		}else if(cond == 0) {
			if(oldTime % 1100 == 0) {
				addPower();
				oldTime = 1;
			}
		}else if(oldTime == 1200) {
			addPower();
			oldTime = 1;
		}
		oldTime++;
		ime++;
		if(ime == 1000) {
			ime = 1;
			for(Node actor: this.getChildren()) {
				if(actor instanceof Ball && !(actor instanceof TemporaryBall) &&!(actor instanceof FieryBall)) {
					double x = ((Ball) actor).getX();
					double y = ((Ball) actor).getY();
					System.out.println(((Ball) actor).getHeight());
					System.out.println(((Ball) actor).getWidth());
					((Ball) actor).setFitHeight(14);
					((Ball) actor).setFitWidth(14);
					
				}
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
		if(lives == 0) {
			for(Node actor: this.getChildren()) {
				this.remove((Actor)actor);
			}
		}
		/*for(Node actor: this.getChildren()) {
			if(actor instanceof Paddle) {
				System.out.println( ((Paddle)actor).getDx() );
			}
		
		}*/
	}
	
	public int getLife() {
		return lives;
	}
	
	public void setLife(int life) 
	{
		lives = life;
	}
	public Score getScore(){
		return score;
	}
}
