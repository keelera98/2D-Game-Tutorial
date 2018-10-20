import java.awt.image.BufferedImage;

//used to load Sprites from a sprite sheet
public class SpriteSheet {

    /*
    * What is a Sprite Sheet?
    *   A sprite sheet is an image that contains multiple sprites.
    *   Usually, different animations of a character, but could
    *   also be a large collection of characters on one sheet.
    *   Used so we don't have tons of sheets for characters and
    *   it is condensed to a few sheets.
    */

    //buffered image that holds the sprite sheet
    private BufferedImage sheet;

    //pass in a sprite sheet to the class
    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

    public BufferedImage crop(int x, int y, int width, int height){
        /*
        * 0,0 is first pixel on upper left of image, this class will crop the image to
        * use the sprite that we want to use
        * each sprite is 32x32 pixels, so the width and height will help us get the full sprite
        * the method will return a sub image with the width and height we passed in
        */

        return sheet.getSubimage(x, y, width, height);
    }

}
