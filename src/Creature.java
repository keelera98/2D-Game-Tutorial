public abstract class Creature extends Entity {

    //makes a health that can't be changed
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFUALT_SPEED = 3.0f;
    //defaults what size the creature is
    public static final int DEFUALT_CREATURE_WIDTH = 64;
    public static final int DEFUALT_CREATURE_HEIGHT = 64;


    protected int health;
    //all movement should be in float
    protected float speed;
    protected float xmove, ymove;


    public Creature(float x, float y, int width, int height){
        //passes the x and y to the parent class constructor
        super(x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFUALT_SPEED;
        xmove = 0;
        ymove = 0;
    }

    public void move(){
        x += xmove;
        y += ymove;
    }

    //GETTERS AND SETTERS

    public float getYmove() {
        return ymove;
    }

    public void setYmove(float ymove) {
        this.ymove = ymove;
    }

    public float getXmove() {
        return xmove;
    }

    public void setXmove(float xmove) {
        this.xmove = xmove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
