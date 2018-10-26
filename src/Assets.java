import java.awt.image.BufferedImage;

//class for any music, sound, or image in game
public class Assets {
    //this is the size of our sprite
    private static final int width = 32, height = 32;
    //this holds all the assets from my sprite sheet
    public static BufferedImage player, dirt, grass, tree, rock;
    //this method will load all assets for our game once, that way it does need to do it in the game loop
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet1.png"));
        SpriteSheet rockSheet = new SpriteSheet(ImageLoader.loadImage("/textures/rock03.jpg"));
        SpriteSheet grassSheet = new SpriteSheet(ImageLoader.loadImage("/textures/clover.jpg"));
        SpriteSheet dirtSheet = new SpriteSheet(ImageLoader.loadImage("/textures/grass1.jpg"));
        SpriteSheet treeSheet = new SpriteSheet(ImageLoader.loadImage("/textures/tree.jpg"));
        SpriteSheet PlayerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/gram.png"));
        //assigns a buffered image to each sprite
        player = PlayerSheet.crop(0, 0, 31, 47);
        dirt = dirtSheet.crop(0, 0, width, height);
        //grass = sheet.crop(width * 4, 0, width, height);
        grass = grassSheet.crop(0, 0, width, height);
        tree = treeSheet.crop(0, 0 , width, height);
        //rock = sheet.crop(0, height, width, height);
        rock = rockSheet.crop(0, 0, width, height);
    }
}
