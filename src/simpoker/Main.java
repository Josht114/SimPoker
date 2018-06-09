/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simpoker;

import simpoker.game.card.Deck;
import simpoker.game.card.Hand;
import simpoker.game.card.Card;
import simpoker.game.card.HandEvaluator;
import simpoker.gui.MainWindow;

/**
 *
 * @author Joshto
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Tester.handTester();
        new MainWindow().setVisible(true);
    }

    private static void deckTest()
    {

        Deck deck = new Deck();

        for (int i = 0; i < 53; i++)
        {

            System.out.println((i+ 1) + ": " + deck.getNextCard().toString());
        }
    }
}
