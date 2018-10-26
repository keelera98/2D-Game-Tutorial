import java.awt.*;
//when a class extends an abstract make sure to have the same methods as the abstract
public class GameState extends State{

    //creates new player
    private Player player;

    private World world;

    public GameState(Handler handler){
        super(handler);

        world = new World(handler, "res/worlds/world1.txt");

        //passes the world through the handler
        handler.setWorld(world);
        //places the player
        player = new Player(handler, 100, 100);

        handler.getGameCamera().move(100, 200);
    }

    public void update(){
        //must be done before player
        world.update();
        //calls update method for player
        player.update();

    }

    public void render(Graphics g){
        //must be done before player
        world.render(g);
        //renders the player
        player.render(g);

        //calls the tile and renders it
        //Tile.tiles[0].render(g, 0, 0);
    }

}
