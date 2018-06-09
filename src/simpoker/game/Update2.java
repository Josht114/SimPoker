/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpoker.game;

import javax.swing.JOptionPane;
import simpoker.game.player.AiPlayer;
import simpoker.game.player.HumanPlayer;
import simpoker.game.player.Player;

/**
 *
 * @author Josh
 */
public class Update2 {

    private int aBet;
    private int hBet;
    private AiPlayer aiPlayer;
    private HumanPlayer hPlayer;
    private int minBet;
    private int pot;

    private void update(int i) {
    }

    public void playTurn(Player fir, Player sec) {
        
        if (fir.getAction() == Player.Action.FOLD) {

            sec.setAction(Player.Action.BET);
            update(8);
            return;
        }

        if (sec.getAction() == Player.Action.FOLD) {

            fir.setAction(Player.Action.BET);
            update(8);
            return;
        }

        int firBet = 0, secBet = 0;

        if (fir.getAction() == Player.Action.BET) {

            firBet = minBet;
        }

        if (sec.getAction() == Player.Action.BET) {

            secBet = minBet;
        }

        if (fir.getAction() == Player.Action.RAISE) {

            firBet = fir.getRaise();
        }

        if (sec.getAction() == Player.Action.RAISE) {

            secBet = sec.getRaise();
        }
        
        if (firBet > secBet) {
            
            if (sec instanceof AiPlayer) {
                
                aiPlayer.meetRaise(firBet);
                if (aiPlayer.getAction() == Player.Action.FOLD) {
                    
                    update(8);
                    return;
                }
            }
            else { // HUMAN.
                
                int awnser = JOptionPane.showConfirmDialog(null, "You have been out raised by " + (firBet - secBet) + ", do you want to"
                        + " meet raise?", "Out Raised!", JOptionPane.YES_NO_OPTION);
                
                if (awnser != 0) {
                    
                    hPlayer.setAction(Player.Action.FOLD);
                    update(8);
                    return;
                }
            }
        }
        else if (secBet > firBet) {
            
            if (fir instanceof AiPlayer) {
                
                aiPlayer.meetRaise(secBet);
                if (aiPlayer.getAction() == Player.Action.FOLD) {
                    
                    update(8);
                    return;
                }
            }
            else { // HUMAN.
                
                int awnser = JOptionPane.showConfirmDialog(null, "You have been out raised by " + (secBet - firBet) + ", do you want to"
                        + " meet raise?", "Out Raised!", JOptionPane.YES_NO_OPTION);
                
                if (awnser != 0) {
                    
                    hPlayer.setAction(Player.Action.FOLD);
                    update(8);
                    return;
                }
            }
            firBet = secBet;
        }
        
        minBet = firBet;
        pot = pot + (minBet * 2);
        fir.setMoney(fir.getMoney() - minBet);
        sec.setMoney(sec.getMoney() - minBet);

        //  MATCH BET SHOULD BE HERE!!

//        if (fir.getAction() == Player.Action.BET) {
//            if (fir.getMoney() >= minBet) {
//                fir.setMoney(fir.getMoney() - minBet);
//                pot = pot + minBet;
//            } else {
//                update(8); // have lost the game
//                return;
//            }
//        }
//
//        if (sec.getAction() == Player.Action.BET) {
//            if (sec.getMoney() >= minBet) {
//                sec.setMoney(fir.getMoney() - minBet);
//                pot = pot + minBet;
//            } else {
//                update(8); // have lost the game
//                return;
//            }
//        }
//
//        if (fir.getAction() == Player.Action.RAISE) {
//            if (fir.getRaise() >= minBet && fir.getMoney() >= minBet) // if raise is large enough and player has enough money
//            {
//                minBet = fir.getRaise();                         //sets minbet to the new amount raised
//                fir.setMoney(fir.getMoney() - fir.getRaise());  //takes raise off player
//                pot = pot + fir.getRaise();                    // add raise to pot
//
//            } else if (fir.getMoney() < minBet) //if player doesnt have enough money
//            {
//                update(8); // have lost game
//                return;
//            } else if (fir.getRaise() < minBet) // if player raise isnt big enough
//            {
//                return;
//            }
//        }
//
//        if (sec.getAction() == Player.Action.RAISE) {
//            if (sec.getRaise() >= minBet && sec.getMoney() >= minBet) // if raise is large enough and player has enough money
//            {
//                minBet = sec.getRaise();                         //sets minbet to the new amount raised
//                sec.setMoney(sec.getMoney() - sec.getRaise());  //takes raise off player
//                pot = pot + sec.getRaise();                    // add raise to pot
//
//            } else if (sec.getMoney() < minBet) //if player doesnt have enough money
//            {
//                update(8); // have lost game
//                return;
//            } else if (sec.getRaise() < minBet) // if player raise isnt big enough
//            {
//                return; // SHOULD NOT RLY REACH HERE
//            }
//
//        }
//
//        if (aBet > hBet) {
//            update(10); // so human can have a chance to meet raise
//        }
//
//        if (aBet < hBet) {
//            aiPlayer.meetRaise(hBet - aBet);  // ai auto meets raise
//        }


    }
}
