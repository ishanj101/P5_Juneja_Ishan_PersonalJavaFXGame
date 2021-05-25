import javafx.scene.image.Image;

public class Brick extends Actor{
	int hitCounter;
	double width;
	double height;
	boolean canMove = false;
	int moveCounter = 0;
	int dx = 0;
	int dy = 0;
	
    public Brick(){
    	hitCounter = 1;
        String path = getClass().getClassLoader().getResource("resources/brick.png").toString();
        Image img = new Image(path,35,30, true,true);
        this.setImage(img);
        setDimensions();
        this.setFitWidth(width);
        this.setFitHeight(height);
       
    }
    public Brick(int hitC){
    	setDimensions();
    	String path;
    	if(hitC >= 4) {
    		path = getClass().getClassLoader().getResource("resources/mbrick2.png").toString();
    	}else
    	if(hitC == 3) {
    		path = getClass().getClassLoader().getResource("resources/mbrick1.png").toString();
    	}else
    	if(hitC == 2) {
    		path = getClass().getClassLoader().getResource("resources/brick2.png").toString();
    	}else {
    		path = getClass().getClassLoader().getResource("resources/brick.png").toString();
    	}
        Image img = new Image(path,35,30, true,true);
        this.setImage(img);
        setDimensions();
        this.setFitWidth(width);
        this.setFitHeight(height);
        hitCounter = hitC;
    }
    
    public Brick(int hitC, boolean canMoves, int dxx, int dyy) {
    	dx = dxx;
    	dy = dyy;
    	canMove = canMoves;
    	setDimensions();
    	String path;
    	if(hitC >= 4) {
    		path = getClass().getClassLoader().getResource("resources/mbrick2.png").toString();
    	}else
    	if(hitC == 3) {
    		path = getClass().getClassLoader().getResource("resources/mbrick1.png").toString();
    	}else
    	if(hitC == 2) {
    		path = getClass().getClassLoader().getResource("resources/brick2.png").toString();
    	}else {
    		path = getClass().getClassLoader().getResource("resources/brick.png").toString();
    	}
        Image img = new Image(path,35,30, true,true);
        this.setImage(img);
        setDimensions();
        this.setFitWidth(width);
        this.setFitHeight(height);
        hitCounter = hitC;
    	
    }
    
    public void setDimensions() {
    	String p = getClass().getClassLoader().getResource("resources/brick.png").toString();
    	Image i = new Image(p);
    	width = i.getWidth();
    	height = i.getHeight();
    }
    
    public void onHit() {
		 hitCounter--;
		 String path2 = getClass().getClassLoader().getResource("resources/brick.png").toString();
		 System.out.println("HC: " + hitCounter);
		 if(hitCounter == 4) {
		 		path2 = getClass().getClassLoader().getResource("resources/mbrick2.png").toString();
		 }else
		 if(hitCounter == 3) {
		 		path2 = getClass().getClassLoader().getResource("resources/mbrick1.png").toString();
	 	}else
		 if(hitCounter == 2) {
		 		path2 = getClass().getClassLoader().getResource("resources/brick2.png").toString();
		 }
		 else if(hitCounter == 1) {
			 path2 = getClass().getClassLoader().getResource("resources/brick.png").toString();
			 
		 }
		 
		 Image img = new Image(path2,35,30, true,true);
	        this.setImage(img);

	        this.setFitWidth(width);
	        this.setFitHeight(height);
		 if(hitCounter == 0) {
			 this.getWorld().remove(this);
		 }
		 
		 
    }
    
    public int getStrength() {
    	return hitCounter;
    }
    public void strengthen() {
    	String path;
    	if(hitCounter <= 3) {
    		hitCounter = hitCounter + 1;
    		int hitC = hitCounter;
    		if(hitCounter == 4) {
		 		path = getClass().getClassLoader().getResource("resources/mbrick2.png").toString();
    		}else
	    	if(hitCounter == 3) {
	    		 path = getClass().getClassLoader().getResource("resources/mbrick1.png").toString();
		 	}else
		 	if(hitC == 2) {
		 		path = getClass().getClassLoader().getResource("resources/brick2.png").toString();
		 	}else {
		 		path = getClass().getClassLoader().getResource("resources/brick.png").toString();
		 	}
			Image img = new Image(path,35,30, true,true);
	        this.setImage(img);
	        this.setFitWidth(width);
	        this.setFitHeight(height);
	        this.setImage(img);
    	}
    }
    
    @Override
    public void act(long now) {
    	if(canMove && moveCounter <= 35) {
    		this.setX(this.getX()+ dx);
    		this.setY(this.getY()+ dy);
    	}else if(canMove){
    		this.setX(this.getX()- dx);
    		this.setY(this.getY()+ dy);
    	}
    	if(moveCounter >= 70) {
    		moveCounter = 0;
    	}
    	moveCounter++;
    }
}
