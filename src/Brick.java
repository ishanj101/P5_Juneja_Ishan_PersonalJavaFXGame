import javafx.scene.image.Image;

public class Brick extends Actor{
	int hitCounter;
	double width;
	double height;
	boolean canMove = false;
	
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
    
    public Brick(int hitC, boolean canMoves) {
    	
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
    
    public void strengthen() {
    	
    	 if(hitCounter <= 2) {
    		 String path;
    		 path = getClass().getClassLoader().getResource("resources/brick2.png").toString();
    		 Image img = new Image(path);
    		 this.setImage(img);
    		 hitCounter = hitCounter + 1;
    	 }
    	 int hitC = hitCounter;
    	 String path;
		 if(hitC == 4) {
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

	        this.setFitWidth(width);
	        this.setFitHeight(height);
    }
    
    @Override
    public void act(long now) {

    }
}
