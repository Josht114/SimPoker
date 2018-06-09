/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simpoker.gui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
import simpoker.game.card.Card;



/**
 *
 * @author Josh
 */
public class ImageStore
{
    private HashMap<String,Image> images;

    public ImageStore()
    {
        images = new HashMap<String,Image>();
           init();

    }

    private void init()
    {
        for (Card.Suit s : Card.Suit.values()) // all suits (values can be called on enums)
        {
            for (int i = 1; i < 14; i++) // all cards in suit
            {
                Card c = new Card(i, s);
                String imageName = s.toString().substring(0, 1).toLowerCase() + i + ".png";
                Image temp = loadImage("images/" + imageName);
                images.put(c.toString(), temp);
            }
        }
        Image back = loadImage("images/back.png");
        images.put("back", back);
    }

    private Image loadImage(String filePath) {


        BufferedImage sourceImage = null;

        URL url = this.getClass().getClassLoader().getResource(filePath);

        if (url == null) {
         
            System.out.println(filePath + " NOT FOUND");
            return null;
        }

        try {

            sourceImage = ImageIO.read(url);
        }
        catch (Exception ex) {

            System.out.println(filePath +" LOAD ERROR: " + ex.getMessage());
            return null;
        }


        return sourceImage;
    }

    private Image getImage(String key) {

        return images.get(key);
    }

    public Image getImage(Card c) {

        return getImage(c.toString());
    }

    public Image getBack() {

        return getImage("back");
    }
}
