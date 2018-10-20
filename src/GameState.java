import java.awt.*;
//when a class extends an abstract make sure to have the same methods as the abstract
public class GameState extends State{

    public GameState(){

    }

    public void update(){

    }

    public void render(Graphics g){
        g.drawImage(Assets.dirt, 0, 0, null);
    }

}
