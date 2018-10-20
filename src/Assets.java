import java.awt.image.BufferedImage;

//class for any music, sound, or image in game
public class Assets {
    //this is the size of our sprite
    private static final int width = 32, height = 32;
    //this holds all the assets from my sprite sheet
    public static BufferedImage player, dirt, grass, tree;
    //this method will load all assets for our game once, that way it does need to do it in the game loop
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet1.png"));
        //assigns a buffered image to each sprite
        player = sheet.crop(0, 0, width, height);
        dirt = sheet.crop(width * 3, 0, width, height);
        grass = sheet.crop(width * 4, 0, width, height);
        tree = sheet.crop(width * 2, 0 , width, height);
    }
}
