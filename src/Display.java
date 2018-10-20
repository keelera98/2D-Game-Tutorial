//allows use of JFrame
import javax.swing.*;
//allows use of canvas
import java.awt.*;

public class Display {
    //creates a new JFrame and created variables to put in the frame
    private JFrame frame;
    //this allows for use of graphics
    private Canvas canvas;
    private String title;
    private int width;
    private int height;

    //constructor takes initializes variables
    public Display(String title, int width, int height){
        this.title = title;
        this.height = height;
        this.width = width;

        createDisplay();
    }

    //creates the actual JFrame
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        //Closes the program when the x is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //optional methods
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //shows the Jframe
        frame.setVisible(true);

        //creates a canvas and sets the width and height
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        //puts the canvas in the frame, and pack makes sure you see all of the canvas
        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }
}
