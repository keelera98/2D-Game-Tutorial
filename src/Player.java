import java.awt.*;

public class Player extends Creature{

    public Player(Handler handler, float x, float y){
        super(handler, x, y, Creature.DEFUALT_CREATURE_WIDTH, Creature.DEFUALT_CREATURE_HEIGHT);
    }

    public void update(){
        //changes speed
        getInput();
        move();
        //centers camera on this player
        handler.getGameCamera().centerOnEntity(this);
    }

    //this actually moves the player
    public void getInput(){
        xmove = 0;
        ymove = 0;

        if(handler.getKeyManager().up){
            //sets the ymove to move up
            ymove = -speed;
        }
        if(handler.getKeyManager().down){
            ymove = speed;
        }
        if(handler.getKeyManager().left){
            xmove = -speed;
        }
        if(handler.getKeyManager().right){
            xmove = speed;
        }

    }

    public void render(Graphics g){

        g.drawImage(Assets.player, (int)(x - handler.getGameCamera().getxOffset()),
                (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
    }

}
