import java.awt.*;

//things in common with every state of the game
//contains what is necessary for each state
public abstract class State {

    //this stores current state
    private static State currentState = null;
    //sets state
    public static void setCurrentState(State state){
        currentState = state;
    }
    //gets state
    public static State getCurrentState(){
        return currentState;
    }

    protected Handler handler;

    //NOTHING TO DO WITH GAME STATE MANAGER
    protected Game game;

    public State(Handler handler){

        this.handler = handler;
    }

    public abstract void update();

    public abstract void render(Graphics g);
}
