/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simpoker.gui;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import simpoker.game.card.Card;

/**
 *
 * @author Josh
 */
public class GameDisplay extends JPanel
{
    private final ImageStore store;

    private Card ai1; // = new Card(1, Card.Suit.CLUBS);
    private Card ai2;
    private Card t1;
    private Card t2;
    private Card t3;
    private Card t4;
    private Card t5;
    private Card p1;
    private Card p2;






    public GameDisplay() {

        super();

        store = new ImageStore();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);    // paint the component

        //draw code here

        //drawing the deck in the top corner
        g.drawImage(store.getBack(), 30, 30, null);
        g.drawImage(store.getBack(), 32, 30, null);
        g.drawImage(store.getBack(), 34, 30, null);
        g.drawImage(store.getBack(), 36, 30, null);
        g.drawImage(store.getBack(), 38, 30, null);
        g.drawImage(store.getBack(), 40, 30, null);
        g.drawImage(store.getBack(), 42, 30, null);

        //drawing ai player two cards
     //   Card c1 = new Card(1, Card.Suit.CLUBS);
     //   g.drawImage(store.getImage(c1), 300, 30, null);
     

        //simple test
        g.setColor(Color.PINK);
        g.drawString("JOSH", 20, 20);

       
        //setting AI players first card
        if (ai1 == null)
        {
          g.drawImage(store.getBack(), 500, 30, null);
        }

        else
        {
          g.drawImage(store.getImage(ai1), 500, 30, null);
        }

        //setting ai players second card
        if (ai2 == null)
        {
          g.drawImage(store.getBack(), 600, 30, null);
        }

        else
        {
          g.drawImage(store.getImage(ai2), 600, 30, null);
        }

        //setting first table card
         if (t1 == null)
        {
          g.drawImage(store.getBack(), 100, 230, null);
        }

        else
        {
          g.drawImage(store.getImage(t1), 100, 230, null);
        }

        //setting second table card
         if (t2 == null)
        {
          g.drawImage(store.getBack(), 200, 230, null);
        }

        else
        {
          g.drawImage(store.getImage(t2), 200, 230, null);
        }

        //setting third table card
         if (t3 == null)
        {
          g.drawImage(store.getBack(), 300, 230, null);
        }

        else
        {
          g.drawImage(store.getImage(t3), 300, 230, null);
        }

         //setting fourth table card
         if (t4 == null)
        {
          g.drawImage(store.getBack(), 400, 230, null);
        }

        else
        {
          g.drawImage(store.getImage(t4), 400, 230, null);
        }

         //setting fith table card
         if (t5 == null)
        {
          g.drawImage(store.getBack(), 500, 230, null);
        }

        else
        {
          g.drawImage(store.getImage(t5), 500, 230, null);
        }

         //setting first player card
         if (p1 == null)
        {
          g.drawImage(store.getBack(), 50, 400, null);
        }

        else
        {
          g.drawImage(store.getImage(p1), 50, 400, null);
        }

         //setting second player card
         if (p2 == null)
        {
          g.drawImage(store.getBack(), 150, 400, null);
        }

        else
        {
          g.drawImage(store.getImage(p2), 150, 400, null);
        }

    }

    public void resetGame()
    {
     ai1 = null;
     ai2 = null;
     t1 = null;
     t2 = null;
     t3 = null;
     t4 = null;
     t5 = null;
     p1 = null;
     p2 = null;
    }




    public void setAi1(Card ai1) {
        this.ai1 = ai1;
    }

    public void setAi2(Card ai2) {
        this.ai2 = ai2;
    }

    public void setP1(Card p1) {
        this.p1 = p1;
    }

    public void setP2(Card p2) {
        this.p2 = p2;
    }

    public void setT1(Card t1) {
        this.t1 = t1;
    }

    public void setT2(Card t2) {
        this.t2 = t2;
    }

    public void setT3(Card t3) {
        this.t3 = t3;
    }

    public void setT4(Card t4) {
        this.t4 = t4;
    }

    public void setT5(Card t5) {
        this.t5 = t5;
    }










}
