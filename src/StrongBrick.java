import javafx.scene.image.Image;

public class StrongBrick extends Brick {
		int hitCounter;
	    public StrongBrick(){
	    	hitCounter = 2;
	    	String path = getClass().getClassLoader().getResource("resources/brick2.png").toString();
	        String path2 = getClass().getClassLoader().getResource("resources/brick.png").toString();
	        Image img = new Image(path);
	        this.setImage(img);
	    }
	    public void onHit() {
	    	 hitCounter--;
	    	 System.out.println(hitCounter);
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
