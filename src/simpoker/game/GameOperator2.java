/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpoker.game;

import javax.swing.JOptionPane;
import simpoker.game.card.Deck;
import simpoker.game.card.Hand;
import simpoker.game.card.HandEvaluator;
import simpoker.game.player.AiPlayer;
import simpoker.game.player.HumanPlayer;
import simpoker.game.player.Player;
import simpoker.gui.GameDisplay;

/**
 *
 * @author Josh
 */
public class GameOperator2 {

    public static final int MIN_BET = 10;    // min bet starts as small blind value
    private HumanPlayer hPlayer;
    private AiPlayer aPlayer;
    private int state;
    private Deck deck;
    private int pot;
    private int turnChecker;
    private int minBet = MIN_BET;
    private Hand tableHand;
    private GameDisplay gDisplay;
    private int raiseDif;
    private boolean doneFlop;
    private boolean doneTurn;
    private boolean doneRiver;
    private Player whoWon;
    private boolean roundWon;

    public GameOperator2(GameDisplay gDisplay) {

        this.gDisplay = gDisplay;

        hPlayer = new HumanPlayer();
        aPlayer = new AiPlayer();
        whoWon = null;
        state = 1;
        deck = new Deck();

        hPlayer.setMoney(500);
        hPlayer.setRaise(10);    // REMOVE ME LATER!!
        aPlayer.setMoney(500);
        doneFlop = false;
        doneRiver = false;
        doneTurn = false;

        turnChecker = 1;
    }

    public void update() {

        update(state);
    }

    private void update(int tmpState) {

        if (roundWon == true) {
            return;
        }

        System.out.println("Update State: " + getState());

        switch (tmpState) {
            case 1:
                reset();
                update(2);
                break;

            case 2:
                dealHoleCards();
                //update(3);
                setSmallBlind();
                state = 3;
                break;

            case 3: //setSmallBlind();
                aPlayer.makeDecision(minBet);
                matchSmallBlind();
                update(4);
                break;

            case 4:

                theFlop();
                aPlayer.makeDecision(minBet);
                doneFlop = true;
                state = 5;
                //update(5);
                break;

            case 5:
                doTurn();

//                if (aPlayer.getAction() == Player.Action.MATCHBET) {
//                    aPlayer.resetAction();
//                    return;
//                }

                if (doneFlop == true && doneTurn == false && doneRiver == false) {
                    update(6);
                    doneTurn = true;
                } else if (doneFlop == true && doneTurn == true && doneRiver == false) {
                    update(7);
                    doneRiver = true;
                } else {

                    update(8);
                    return;
                }

                break;

            case 6:
                theTurn();
                aPlayer.makeDecision(minBet);

                state = 5;
                break;

            case 7:
                theRiver();
                aPlayer.makeDecision(minBet);
                state = 5;
                break;

            case 8:
                //  getFold();
                getWinner();
                //reset();
                return;
            //break;

//                int i =  aPlayer.getRaise() - minBet;
//           switch (hPlayer.getAction())
//           {
//                case BET: 
//                            hPlayer.setMoney(hPlayer.getMoney() - i);
//                            pot = pot + i;
//                    
//                case RAISE: 
//                            
//                            hPlayer.setMoney(hPlayer.getMoney() - i);
//                            pot = pot + i;
//                case MATCHBET:
//                            
//                            hPlayer.setMoney(hPlayer.getMoney() - i);
//                            pot = pot + i;
//                case FOLD:    
//                            
//                            hPlayer.setMoney(hPlayer.getMoney() - i);
//                            pot = pot + i;
//           }

        }

        // CHECK WHATEVER FOR STATE 9

       
        if (aPlayer.getMoney() <= 0 || hPlayer.getMoney() <= 0) {
            update(8);
            state = 9;
            roundWon = true;

            if (aPlayer.getMoney() <= 0) {

                aPlayer.setMoney(0);
                hPlayer.setMoney(1000);
                whoWon = hPlayer;
            } else {

                aPlayer.setMoney(1000);
                hPlayer.setMoney(0);
                whoWon = aPlayer;
            }
        }
    }

    public void reset() {
        state = 1;

        minBet = MIN_BET;
        deck.shuffle();
        hPlayer.clearHand();
        aPlayer.clearHand();
        whoWon = null;
        tableHand = new Hand();
        pot = 0;

        state = 2;
        roundWon = false;

        doneFlop = false;
        doneRiver = false;
        doneTurn = false;

        gDisplay.setAi1(null);
        gDisplay.setAi2(null);
        gDisplay.setP1(null);
        gDisplay.setP2(null);
        gDisplay.setT1(null);
        gDisplay.setT2(null);
        gDisplay.setT3(null);
        gDisplay.setT4(null);
        gDisplay.setT5(null);
        gDisplay.repaint();

        // SET NULLS GRAPHICS
        // REPAINT.
        //
    }

    private void dealHoleCards() {
        state = 2;

        hPlayer.SetHand(deck.getNextCard(), deck.getNextCard());
        aPlayer.SetHand(deck.getNextCard(), deck.getNextCard());
        gDisplay.setP1(hPlayer.getCard(0));
        gDisplay.setP2(hPlayer.getCard(1));

        gDisplay.setAi1(aPlayer.getCard(0));      //TEMP
        gDisplay.setAi2(aPlayer.getCard(1));       //TEMP

        gDisplay.repaint();
    }

    public void theFlop() // places the first three cards on the table
    {
        state = 4;
        tableHand.setCard1(deck.getNextCard());
        tableHand.setCard2(deck.getNextCard());
        tableHand.addCard(deck.getNextCard());
        gDisplay.setT1(tableHand.getCard(0));
        gDisplay.setT2(tableHand.getCard(1));
        gDisplay.setT3(tableHand.getCard(2));
        gDisplay.repaint();
        hPlayer.givCard(tableHand.getCard(0));
        hPlayer.givCard(tableHand.getCard(1));
        hPlayer.givCard(tableHand.getCard(2));
        aPlayer.givCard(tableHand.getCard(0));
        aPlayer.givCard(tableHand.getCard(1));
        aPlayer.givCard(tableHand.getCard(2));
    }

    public void theTurn() //places the next one card on the table
    {
        state = 6;
        tableHand.addCard(deck.getNextCard());
        gDisplay.setT4(tableHand.getCard(3));
        hPlayer.givCard(tableHand.getCard(3));
        aPlayer.givCard(tableHand.getCard(3));
        gDisplay.repaint();
    }

    public void theRiver() // places the last card on the table
    {
        state = 7;
        tableHand.addCard(deck.getNextCard());
        gDisplay.setT5(tableHand.getCard(4));
        hPlayer.givCard(tableHand.getCard(4));
        aPlayer.givCard(tableHand.getCard(4));
        gDisplay.repaint();
    }

    public void setSmallBlind() {

        if (isEven(turnChecker)) {
            hPlayer.setMoney(hPlayer.getMoney() - MIN_BET);   //taking small blind away
        } else {
            aPlayer.setMoney(aPlayer.getMoney() - MIN_BET);   //taking small blind away
        }
        pot = pot + MIN_BET;    //paying in small blind
    }

    public void matchSmallBlind() {
        if (isEven(turnChecker)) {
            if (aPlayer.getAction() == Player.Action.BET || aPlayer.getAction() == Player.Action.RAISE) {
                aPlayer.setMoney(aPlayer.getMoney() - MIN_BET);
                pot = pot + MIN_BET;
            } else {

                update(8);
                //   return;
            }
            // playTurn(aPlayer, hPlayer);
        } else {
            if (hPlayer.getAction() == Player.Action.MATCHBET) // Player.Action.BET || hPlayer.getAction() == Player.Action.RAISE)
            {
                hPlayer.setMoney(hPlayer.getMoney() - MIN_BET);
                pot = pot + MIN_BET;
            } else {

                update(8);
            }
            // playTurn(hPlayer, aPlayer);
        }

    }

    public void doTurn() {
        if (isEven(turnChecker)) {
            playTurn(hPlayer, aPlayer);
        } else {
            playTurn(aPlayer, hPlayer);
        }

    }

    public Player whoGoesFirst() {
        if (isEven(turnChecker)) {
            return hPlayer;
        } else {
            return aPlayer;
        }

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
                
                aPlayer.meetRaise(firBet);
                if (aPlayer.getAction() == Player.Action.FOLD) {
                    
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
                
                aPlayer.meetRaise(secBet);
                if (aPlayer.getAction() == Player.Action.FOLD) {
                    
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
//        // aPlayer.setRandNumber();
//
//        if (sec.getAction() == Player.Action.RAISE) {
//            //  update(10);
////          int i =  sec.getRaise() - minBet;
////           switch (fir.getAction())
////           {
////                case BET: 
////                            fir.setMoney(fir.getMoney() - i);
////                            pot = pot + i;
////                    
////                case RAISE: 
////                            
////                            fir.setMoney(fir.getMoney() - i);
////                            pot = pot + i;
////                case MATCHBET:
////                            
////                            fir.setMoney(fir.getMoney() - i);
////                            pot = pot + i;
////                case FOLD:    
////                            
////                            fir.setMoney(fir.getMoney() - i);
////                            pot = pot + i;
////           }
//        }
//
//        if (sec.getAction() != Player.Action.MATCHBET && fir.getAction() != null) {
//            switch (fir.getAction()) {
//                case BET:
//                    if (fir.getMoney() >= minBet) {
//                        fir.setMoney(fir.getMoney() - minBet);
//                        pot = pot + minBet;
//                    } else {
//                        update(8); // have lost the game
//                        return;
//                    }
//                    break;
//
//                case FOLD:
//                    // sec.setMoney(sec.getMoney() + pot);
//                    // pot = 0;
//                    update(8); // have lost round
//                    return;
//
//                case RAISE:
//                    if (fir.getRaise() >= minBet && fir.getMoney() >= minBet) // if raise is large enough and player has enough money
//                    {
//                        raiseDif = fir.getRaise() - minBet;              // sets raise dif to the different between the last min bet and the new one after raise
//                        minBet = fir.getRaise();                         //sets minbet to the new amount raised
//                        fir.setMoney(fir.getMoney() - fir.getRaise());  //takes raise off player
//                        pot = pot + fir.getRaise();                    // add raise to pot
//
//                    } else if (fir.getMoney() < minBet) //if player doesnt have enough money
//                    {
//                        update(8); // have lost game
//                        return;
//                    } else if (fir.getRaise() < minBet) // if player raise isnt big enough
//                    {
//                        return;
//                    }
//
//                case MATCHBET:
//                    fir.setMoney(fir.getMoney() - raiseDif);
//                    pot = pot + raiseDif;
//                    return;
//
//            }
//        }
//
//        //SECOND PLAYERS TURN NOW
//        if (fir.getAction() != Player.Action.MATCHBET && sec.getAction() != null) {
//            switch (sec.getAction()) {
//                case BET:
//                    if (sec.getMoney() >= minBet) {
//                            System.out.println(sec.getMoney());
//                        sec.setMoney(sec.getMoney() - minBet);
//                        pot = pot + minBet;
//                         System.out.println(sec.getMoney());
//                    } else {
//
//                        update(8); // have lost the game
//                        return;
//                    }
//                    break;
//
//                case FOLD:
//                    // fir.setMoney(fir.getMoney() + pot);
//                    // pot = 0;
//                    update(8); // have lost round
//                    return;
//
//                case RAISE:
//
//                    if (sec.getRaise() >= minBet && sec.getMoney() >= minBet) {
//                        raiseDif = sec.getRaise() - minBet;
//                        minBet = sec.getRaise();
//                        sec.setMoney(sec.getMoney() - sec.getRaise());  //takes raise off
//                        pot = pot + sec.getRaise();
//
//                        if (raiseDif > 0 && fir instanceof AiPlayer) { // AI NEEDS TO BE TOLD IT HAS TO MEET RAISE.
//
//                            aPlayer.meetRaise(minBet); // DECIDES IF IT WANTS TO MEET OR FOLD
//                            update(5);
//                            return;
//                        } else {
//                            if (sec instanceof HumanPlayer) {
//                                update(10);
//                            } else {
//                                aPlayer.meetRaise(minBet);
//                            }
//                            return;
//                        }
//
//                    } else if (sec.getMoney() < minBet) {
//
//                        update(8); // have lost game
//                        return;
//                    } else if (sec.getRaise() < minBet) {
//
//                        if (sec instanceof AiPlayer) { // AI NEEDS TO BE TOLD IT HAS TO MEET RAISE.
//
//
//                            aPlayer.meetRaise(minBet);
//                            // DECIDES IF IT WANTS TO MEET OR FOLD
//                            update(5);
//                            return;
//                        } else {
//                            update(10);
//                            return;
//                        }
//                    }
//                    break;
//
//                case MATCHBET:
//                    sec.setMoney(sec.getMoney() - raiseDif);
//                    pot = pot + raiseDif;
//                //find out how much you need to add in too meet raise and pay it
//
//            }
//        }
//        // aPlayer.setRandNumber();
    }

    public Player getWhoWon() {

        return whoWon;
    }

    private void getWinner() {
        state = 8;
        if (hPlayer.getAction() == Player.Action.FOLD) // || HandEvaluator.compareHands(aPlayer.getMyHand(), hPlayer.getMyHand()) == aPlayer.getMyHand()) //if AI winds
        {
            aPlayer.setMoney(aPlayer.getMoney() + pot);
            pot = 0;
            System.out.println("APlayer Wins");
            whoWon = aPlayer;
        } else if (aPlayer.getAction() == Player.Action.FOLD) //|| HandEvaluator.compareHands(aPlayer.getMyHand(), hPlayer.getMyHand()) == hPlayer.getMyHand()) {
        {
            hPlayer.setMoney(hPlayer.getMoney() + pot);
            pot = 0;
            System.out.println("HPlayer Wins");
            whoWon = hPlayer;
        } else if (HandEvaluator.compareHands(aPlayer.getMyHand(), hPlayer.getMyHand()) == aPlayer.getMyHand()) {
            aPlayer.setMoney(aPlayer.getMoney() + pot);
            pot = 0;
            System.out.println("APlayer Wins");
            whoWon = aPlayer;
        } // THIS MAY BE WRONG!!!!
        else if (HandEvaluator.compareHands(aPlayer.getMyHand(), hPlayer.getMyHand()) == hPlayer.getMyHand()) {
            hPlayer.setMoney(hPlayer.getMoney() + pot);
            pot = 0;
            System.out.println("HPlayer Wins");
            whoWon = hPlayer;
        } //THIS MAY BE WRONG!!!!
        else {
            int halfPot = pot / 2;
            aPlayer.setMoney(aPlayer.getMoney() + halfPot);
            hPlayer.setMoney(hPlayer.getMoney() + halfPot);
            pot = 0;
            System.out.println("draw");
            whoWon = null;
        }
        turnChecker++;
        roundWon = true;
    }

    public void getFold() {
        if (hPlayer.getAction() == Player.Action.FOLD) // || HandEvaluator.compareHands(aPlayer.getMyHand(), hPlayer.getMyHand()) == aPlayer.getMyHand()) //if AI winds
        {
            aPlayer.setMoney(aPlayer.getMoney() + pot);
            pot = 0;
            System.out.println("APlayer Wins");
            whoWon = aPlayer;
        } else if (aPlayer.getAction() == Player.Action.FOLD) //|| HandEvaluator.compareHands(aPlayer.getMyHand(), hPlayer.getMyHand()) == hPlayer.getMyHand()) {
        {
            hPlayer.setMoney(hPlayer.getMoney() + pot);
            pot = 0;
            System.out.println("HPlayer Wins");
            whoWon = hPlayer;
        }
        turnChecker++;
        roundWon = true;
    }

    private void matchRaise() {
    }

    private boolean aiFold() {
        return aPlayer.getAction() == Player.Action.FOLD;
    }

    private boolean aiRaise() {
        return aPlayer.getAction() == Player.Action.RAISE;
    }

    private boolean aiBet() {
        return aPlayer.getAction() == Player.Action.BET;
    }

    private boolean aiLost() {
        return aPlayer.getMoney() <= 0;
    }

    private boolean huFold() {
        return hPlayer.getAction() == Player.Action.FOLD;
    }

    private boolean huRaise() {
        return hPlayer.getAction() == Player.Action.RAISE;
    }

    private boolean huBet() {
        return hPlayer.getAction() == Player.Action.BET;
    }

    private boolean huLost() {
        return hPlayer.getMoney() <= 0;
    }

    public int getMinBet() {
        return minBet;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public AiPlayer getAIPlayer() {
        return aPlayer;
    }

    public int getPot() {
        return pot;
    }

    public HumanPlayer getHumanPlayer() {

        return hPlayer;
    }

    public int getState() {
        return state;
    }
}
