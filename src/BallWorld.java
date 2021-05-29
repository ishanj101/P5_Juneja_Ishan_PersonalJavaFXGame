import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class BallWorld extends World{

	private Score score;
	private long oldTime = 1;
	private long ime = 1;
	int lives = 3;
	int level = 0;
	public BallWorld(int bricks, int level){
		score = new Score();
		score.setX(30);
		score.setY(30);
		this.getChildren().add(score);
		addPower();
		setBrickCount(bricks);
		this.level = level;
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
		int cond = rand.nextInt(3);
		int cond2 = rand.nextInt(2);
		
	    int xx = rand.nextInt((int) this.getWidth());
	    int yy = rand.nextInt((int) this.getHeight());
	    
		if(this.getBricksHit() != 0 && this.getBricksHit()%(15 - (level * 2)) == 0) {
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
					double dxx = ((FieryBall) actor).getDx();
					double dyy = ((FieryBall) actor).getDy();
					((FieryBall) actor).getWorld().remove((FieryBall)actor);
					Ball ball2 = new Ball();
					ball2.setSpeed(dxx, dyy);
					ball2.setX(x);
					ball2.setY(y);
					this.getChildren().add(ball2);
				}
			}
		}
		if(lives == 0) {
			Canvas c = new Canvas();
			Label lblGameOver = new Label("Game Over");
			lblGameOver.setTextAlignment(TextAlignment.CENTER);
	        lblGameOver.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 35));
	        lblGameOver.setEffect(new InnerShadow(10, Color.CRIMSON));
	        
	        FadeTransition gameOverAnimation = new FadeTransition(Duration.millis(500), lblGameOver);
	        gameOverAnimation.setFromValue(0.1);
	        gameOverAnimation.setToValue(1);
	        gameOverAnimation.setCycleCount(-1);
	        gameOverAnimation.setAutoReverse(true);
	        gameOverAnimation.play();
	        
	        StackPane a = new StackPane(c, lblGameOver);
	        a.setPadding(new Insets(125));
	        a.setAlignment(Pos.BOTTOM_CENTER );
	        
	        this.add(a);
			lives = -1;
			
		}
		if(this.getBrickCount() == 1) {
			Canvas c = new Canvas();
			Label lblGameOver = new Label("You Passed");
			lblGameOver.setTextAlignment(TextAlignment.CENTER);
	        lblGameOver.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 35));
	        lblGameOver.setEffect(new InnerShadow(10, Color.SPRINGGREEN));
	        
	        FadeTransition gameOverAnimation = new FadeTransition(Duration.millis(500), lblGameOver);
	        gameOverAnimation.setFromValue(0.1);
	        gameOverAnimation.setToValue(1);
	        gameOverAnimation.setCycleCount(-1);
	        gameOverAnimation.setAutoReverse(true);
	        gameOverAnimation.play();
	        
	        StackPane a = new StackPane(c, lblGameOver);
	        a.setPadding(new Insets(125));
	        a.setAlignment(Pos.BOTTOM_CENTER );
	        
	        this.add(a);
	        this.setBrickCount(0);
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
