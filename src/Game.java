//credit for code goes to CodeNMore
//modified by Austin Keeler
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

//holds all base code for the game
//runnable is a child class we'll be using for threading
public class Game implements Runnable{
    private Display display;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bf;
    private Graphics g;
    //private BufferedImage testImage;
    //private BufferedImage testImage2;
    //private BufferedImage testSprite;
    //private SpriteSheet sheet;
    public int width, height;
    public String title;

    //States
    private State gameState;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    //initializes graphics for the game
    private void init(){
        display = new Display(title, width, height);
        //initialize all our assets
        Assets.init();
        //made sure to add the folder with the image into you library for the project
        //file -> project structure -> library -> add class folder
        //testImage = ImageLoader.loadImage("/textures/download.jpg");
        //testImage2 = ImageLoader.loadImage("/textures/download2.jpeg");
        //testSprite = ImageLoader.loadImage("/textures/testSpriteSheet.png");
        //sheet = new SpriteSheet(testSprite);

        //sets a state to a game state
        //all states are declared as a State but initialized to what they are
        gameState = new GameState();
        //current state is now the game state
        State.setCurrentState(gameState);
    }

    //can also be called tick(), updates the game
    private void update(){
        //checks to make sure there is a current state
        if(State.getCurrentState() != null){
            //updates the state
            State.getCurrentState().update();
        }
    }

    //renders graphics
    private void render(){
        //uses the buffer strategy to render the graphics
        //a buffer is screen within a screen
        bf = display.getCanvas().getBufferStrategy();
        //creates buffer strategy if one doesn't exist
        if(bf == null){
            //no need for more than 3 buffers
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        //draws to the canvas, using graphics object
        g = bf.getDrawGraphics();

        //clear the screen, do every time you draw
        g.clearRect(0,0, width, height);
        //draw here
        //g.fillRect(0, 0, width, height);
        //java uses pixels to measure x,y. 0,0 is the upper left of the screen, y axis is inversed

        /*basic shapes
        *g.setColor(Color.black);
        *g.fillRect(10, 50, 50, 70);
        *
        *everything after set color is colored that color
        *g.setColor(Color.red);
        *g.fillRect(0, 0, 10, 10);*/
        //end drawing

        //used to draw a image
        //g.drawImage(testImage, 0,0, null);
        //g.drawImage(testImage2, 40,40, null);

        //this allows me to show my sprites, it is inefficient, just to test the sprite sheet
        //g.drawImage(sheet.crop(0, 0, 32, 32), 5, 5, null);
        //g.drawImage(sheet.crop(32, 0, 32, 32), 40, 5, null);

        //checks that state actually exists
        if(State.getCurrentState() != null){
            //renders the graphics
            State.getCurrentState().render(g);
        }

        //this actually shows the drawing to the screen
        bf.show();
        g.dispose();
    }

    //need this for the runnable class
    public void run(){
        //calls on the graphic to get the game started
        init();

        //the amount of times we want to update per second
        int fps = 60;
        //divides fps by 1 second in nano seconds(1bil nano seconds)
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        //returns the amount of time in nano seconds our computer is running at
        long lastTime = System.nanoTime();
        //following used to make a fps counter
        long timer = 0;
        int ticks = 0;

        while(running){
            //current time the computer is at
            now = System.nanoTime();
            //gets the amount time passed sense the code here was last called
            //then divides by the amount of time the tick should be called
            //delta tells the computer when to call update and render methods
            delta += (now - lastTime) / timePerTick;
            //timer is equal to amount of time has passed since calling this code
            timer += now - lastTime;
            //updates the lastTime variable
            lastTime = now;

            //checks to see if the correct time has passed to render and update
            if(delta >= 1) {
                update();
                render();
                //increases ticks everytime the update and render is called
                ticks++;
                //decrements delta to reset it
                delta--;
            }

            //if the timer has reaches 1 seconds print the amount of ticks
            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
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
