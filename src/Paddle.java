import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Paddle extends Actor{

    private double dx;
    private double pos;
    private double w;
    private double h;
    private boolean big = false;

    public Paddle(){
        String path = getClass().getClassLoader().getResource("resources/paddle.png").toString();
        Image img = new Image(path);
        w = img.getWidth();
        h = img.getHeight();
        this.setImage(img);
        dx = 0;
        pos = this.getX();
    }
    
    public void increase() {
    	String path = getClass().getClassLoader().getResource("resources/paddle.png").toString();
    	Image img = new Image(path,w+50,h+25,true,true);
    	this.setImage(img);
    }
    
    public void decrease() {
    	 String path = getClass().getClassLoader().getResource("resources/paddle.png").toString();
         Image img = new Image(path);
    	this.setImage(img);
    }

    @Override
    public void act(long now) {
        if (getWorld().isKeyDown(KeyCode.LEFT)){
            double speed = this.getWidth()/12;
            dx = speed;
            if(this.getX()>=speed/2) this.move(-speed, 0);
        }
        if (getWorld().isKeyDown(KeyCode.RIGHT)){
            double speed = this.getWidth()/12;
            dx = speed;
            if(this.getX() <= getWorld().getWidth()-this.getWidth()-speed/2) this.move(speed, 0);
        }
    }

    public boolean isBig() {
    	return big;
    }
    public void setBig(boolean a) {
    	big = a;
    }
    public void setDx(double change){
        dx = change;
    }

    public double getDx(){
        return dx;
        
    }

    public double getPos() {
        return pos;
    }

    public void setPos(double pos) {
        this.pos = pos;
    }
}
