import java.awt.*;

public class Player extends Creature{

    private Game game;

    public Player(Game game, float x, float y){
        super(x, y, Creature.DEFUALT_CREATURE_WIDTH, Creature.DEFUALT_CREATURE_HEIGHT);
        this.game = game;
    }

    public void update(){
        //changes speed
        getInput();
        move();
    }

    //this actually moves the player
    public void getInput(){
        xmove = 0;
        ymove = 0;

        if(game.getKeyManager().up){
            //sets the ymove to move up
            ymove = -speed;
        }
        if(game.getKeyManager().down){
            ymove = speed;
        }
        if(game.getKeyManager().left){
            xmove = -speed;
        }
        if(game.getKeyManager().right){
            xmove = speed;
        }

    }

    public void render(Graphics g){
        g.drawImage(Assets.player, (int)x, (int)y, width, height, null);
    }

}
