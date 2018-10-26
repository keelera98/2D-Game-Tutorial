import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//uses javas key listener
public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right;

    public KeyManager(){
        //array for all keys, each key has a keycode
        keys = new boolean[256];
    }

    public void update(){
        //gets the key code for a specific key
        up = keys[KeyEvent.VK_W];
        right = keys[KeyEvent.VK_D];
        left = keys[KeyEvent.VK_A];
        down = keys[KeyEvent.VK_S];

    }

    //FOLLOWING THREE CLASSES REQUIRED BY JAVA
    //called when user presses a key
    public void keyPressed(KeyEvent e){
        //gets key code for the key presses and sets to true, this how we know if a key was pressed
        keys[e.getKeyCode()] = true;
        //System.out.println("Pressed");
    }

    //called when a user lets go of a key
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e){

    }
}
