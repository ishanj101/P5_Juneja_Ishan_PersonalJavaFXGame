import javafx.scene.image.Image;

public class Brick extends Actor{
	int hitCounter;
    public Brick(){
    	hitCounter = 1;
        String path = getClass().getClassLoader().getResource("resources/brick.png").toString();
        Image img = new Image(path);
        this.setImage(img);
    }
    public Brick(int hitC){
    	String path;
    	if(hitC >= 2) {
    		path = getClass().getClassLoader().getResource("resources/brick2.png").toString();
    	}else {
    		path = getClass().getClassLoader().getResource("resources/brick.png").toString();
    	}
        Image img = new Image(path);
        this.setImage(img);
        hitCounter = hitC;
    }
    
    public void onHit() {
		 hitCounter--;
		 System.out.println("HC: " + hitCounter);
		 if(hitCounter == 1) {
		    	 String path2 = getClass().getClassLoader().getResource("resources/brick.png").toString();
			     Image img = new Image(path2);
			     this.setImage(img);
		 }else if(hitCounter == 0) {
			 this.getWorld().remove(this);
		 }
    }
    
    @Override
    public void act(long now) {

    }
}
