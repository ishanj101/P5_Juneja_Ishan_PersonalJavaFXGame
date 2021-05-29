import java.util.Scanner;
import java.util.Stack;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {
	public BooleanProperty gameOver;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }
    BallWorld ballWorld;
    static Paddle paddle;

    public Paddle getPaddle() {
    	return paddle;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
    	System.out.println("Click a number from 1 to 5 to select your level to play");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1) {
        	first(stage);
        }
    	if(choice == 2) {
        	second(stage);
        }

    }
    
    public void second(Stage stage) {
    	stage.setTitle("BallWorld - Level 2");
        BorderPane rootNode = new BorderPane();
        ballWorld = new BallWorld(18,1);
        ballWorld.setPrefSize(500, 500);
        
        rootNode.setCenter(ballWorld);
        
        //Ball type
        Ball ball = new Ball();
        ball.setX(250);
        ball.setY(250);
        ball.setSpeed(5,-3.25);
        

        paddle = new Paddle();
        paddle.setX(250);
        paddle.setY(ballWorld.getPrefHeight() - paddle.getHeight());
        
        Enemy trial = new Enemy();
        trial.setX(100);
        trial.setY(100);
        ballWorld.add(trial);

        double brickX = 50;
        double brickY = 50;
        double brickWidth = 0;
        double size = 0;
        for (int i = 0; i < 6; i++) {
            Brick brick = new Brick(3);
            brick.setX(brickX);
            brick.setY(brickY);
            brickWidth = brick.getWidth();
            size = brick.getHeight();
            brickX += brick.getWidth()+15;
            ballWorld.add(brick);
        }
        
        brickX = 55 + brickWidth;
        brickY +=size;
        for (int i = 0; i < 8; i++) {
            Brick brick = new Brick(2);
            brick.setX(brickX);
            brick.setY(brickY);
            brickX += brick.getWidth()+5;
            ballWorld.add(brick);
        }
        ballWorld.add(ball);
        ballWorld.add(paddle);
        

        ballWorld.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //paddle.setMoving(true);
                if(event.getX()> paddle.getX()) {
                	paddle.setDx(2);
                }else {
                	paddle.setDx(-2);
                }
                if (event.getX() <= ballWorld.getWidth() - paddle.getWidth()) paddle.setX(event.getX());
                paddle.setPos(event.getX());

            }
        });


        ballWorld.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                ballWorld.addKey((event.getCode()));
                double speed = paddle.getWidth() / 3;
                if (paddle.getX() >= speed / 2 && event.getCode() == KeyCode.LEFT) paddle.move(-speed, 0);
                if (paddle.getX() <= ballWorld.getWidth() - paddle.getWidth() - speed / 2 && event.getCode() == KeyCode.RIGHT)
                    paddle.move(speed, 0);
                if(event.getCode() == KeyCode.DIGIT1) {
                	System.out.println("1");
                }
            }
            
        });

        ballWorld.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                ballWorld.removeKey((event.getCode()));
                paddle.setDx(0);
            }
        });
       
        ballWorld.start();
        
       
        

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.show();

        ballWorld.requestFocus();
    }
    public void first(Stage stage) {
    	stage.setTitle("BallWorld - Level 1");
        BorderPane rootNode = new BorderPane();
        ballWorld = new BallWorld(18,1);
        ballWorld.setPrefSize(500, 500);
        
        rootNode.setCenter(ballWorld);
        
        //Ball type
        Ball ball = new Ball();
        ball.setX(250);
        ball.setY(250);
        ball.setSpeed(5,-3);
        

        paddle = new Paddle();
        paddle.setX(250);
        paddle.setY(ballWorld.getPrefHeight() - paddle.getHeight());
        
        Enemy trial = new Enemy();
        trial.setX(100);
        trial.setY(100);
        ballWorld.add(trial);

        double brickX = 50;
        double brickY = 150;
        double brickWidth = 0;
        double size = 0;
        for (int i = 0; i < 10; i++) {
            Brick brick = new Brick(2);
            brick.setX(brickX);
            brick.setY(brickY);
            brickWidth = brick.getWidth();
            size = brick.getHeight();
            brickX += brick.getWidth()+5;
            ballWorld.add(brick);
        }
        
        brickX = 55 + brickWidth;
        brickY +=size;
        for (int i = 0; i < 8; i++) {
            Brick brick = new Brick(1);
            brick.setX(brickX);
            brick.setY(brickY);
            brickX += brick.getWidth()+5;
            ballWorld.add(brick);
        }

        


        ballWorld.add(ball);
        ballWorld.add(paddle);
        

        ballWorld.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //paddle.setMoving(true);
                if(event.getX()> paddle.getX()) {
                	paddle.setDx(2);
                }else {
                	paddle.setDx(-2);
                }
                if (event.getX() <= ballWorld.getWidth() - paddle.getWidth()) paddle.setX(event.getX());
                paddle.setPos(event.getX());

            }
        });


        ballWorld.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                ballWorld.addKey((event.getCode()));
                double speed = paddle.getWidth() / 3;
                if (paddle.getX() >= speed / 2 && event.getCode() == KeyCode.LEFT) paddle.move(-speed, 0);
                if (paddle.getX() <= ballWorld.getWidth() - paddle.getWidth() - speed / 2 && event.getCode() == KeyCode.RIGHT)
                    paddle.move(speed, 0);
                if(event.getCode() == KeyCode.DIGIT1) {
                	System.out.println("1");
                }
            }
            
        });

        ballWorld.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                ballWorld.removeKey((event.getCode()));
                paddle.setDx(0);
            }
        });
       
        ballWorld.start();
        
       
        

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.show();

        ballWorld.requestFocus();
    }

}
