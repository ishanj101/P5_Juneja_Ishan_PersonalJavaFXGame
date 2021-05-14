import java.util.Random;

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
	    
		
	}
	
	@Override
	public void act(long now) {
		Random rand = new Random();
		int cond = rand.nextInt(2);
	    
		if(cond == 1 ) {
			if(oldTime % 500 == 0) {
				addPower();
				oldTime = 1;
				
			}
		
		}else if(cond == 2 || cond == 1) {
			if(oldTime % 800 == 0) {
				addPower();
				oldTime = 1;
			}
		}else if(cond == 0) {
			if(oldTime % 600 == 0) {
				addPower();
				oldTime = 1;
			}
		}else if(oldTime == 1000) {
			addPower();
			oldTime = 1;
			System.out.println("Aaaaaaa");
		}
		oldTime++;
		
	}

	public Score getScore(){
		return score;
	}
}
