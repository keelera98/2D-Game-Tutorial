import java.awt.*;
import java.awt.image.BufferStrategy;

//holds all base code for the game
//runnable is a child class we'll be using for threading
public class Game implements Runnable{
    private Display display;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bf;
    private Graphics g;
    public int width, height;
    public String title;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    //initializes graphics for the game
    private void init(){
        display = new Display(title, width, height);
    }

    //can also be called tick(), updates the game
    private void update(){

    }

    //renders graphics
    private void render(){
        //uses the buffer strategy to render the graphics
        //a buffer is screen within a screen
        bf = display.getCanvas().getBufferStrategy();
    }

    //need this for the runnable class
    public void run(){
        //calls on the graphic to get the game started
        init();

        while(running){
            update();
            render();
        }

        //just in case it doesn't stop the first time
        stop();
    }

    /*
     The game loop:
        updates variables and positions of objections,
        then renders and draws everything on the screen.
        This repeats until you stop playing the game.
     */

    //both methods used for starting and stopping threads
    //threading keeps the game loop going
    public synchronized void start(){
        //checks to see if already running don't re run code
        if(!running) {
            running = true;
            //the game class is now in the thread
            thread = new Thread(this);
            //calls the run method
            thread.start();
        }
    }

    public synchronized void stop(){
        if(running){
            running = false;
            try {
                thread.join();
            } catch (Exception e) {
            }
        }
    }
}
