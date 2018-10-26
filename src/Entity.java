import java.awt.*;

//parent class for all entities, then child classes will be more specific
public abstract class Entity {

    //protected  variables are private but extended classes can still use them
    protected float x;
    protected float y;
    //used to change sizes of images
    protected int width, height;

    public Entity(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }
}
