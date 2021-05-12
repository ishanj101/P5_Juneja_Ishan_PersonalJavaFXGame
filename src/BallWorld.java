public class BallWorld extends World{

	private Score score;
	private long oldTime = 0;

	public BallWorld(){
		score = new Score();
		score.setX(30);
		score.setY(30);
		this.getChildren().add(score);
	}
	
	@Override
	public void act(long now) {
		if(oldTime >= 500 && oldTime % 500 == 0) {

			System.out.println("Here: " + oldTime);
			
		}
		oldTime++;
		System.out.println("Here: " + oldTime);
	}

	public Score getScore(){
		return score;
	}
}
