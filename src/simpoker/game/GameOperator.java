/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simpoker.game;

import simpoker.game.card.Card;
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
public class GameOperator {

    public static final int MIN_BET = 10;    // min bet starts as small blind value

    private HumanPlayer hPlayer;
    private AiPlayer aPlayer;

    private static int stateValue; // an int that will allow you to-


    private Deck deck;
    private int pot;
    private int turnChecker;
    private int minBet;
    
    private Hand tableHand;
    private OperatorState gState;
    private GameDisplay gDisplay;

    private int roundNum;



    private enum OperatorState
    {
        RUNNING, FINISHED;
    }
    
    /**
     * constructor
     */
    public GameOperator(GameDisplay gDisplay) {

        this.gDisplay = gDisplay;
        
        hPlayer = new HumanPlayer();
        aPlayer = new AiPlayer();
        
        reset();
    }


    public HumanPlayer getHumanPlayer() {

        return hPlayer;
    }

    private void newGame()
    {
        gDisplay.resetGame();
        roundNum = 0;
        deck = new Deck();
        pot = 0;
        minBet = MIN_BET;
        tableHand = new Hand();
        hPlayer.clearHand();
        aPlayer.clearHand();
        hPlayer.setAction(null);
        hPlayer.SetHand(deck.getNextCard(), deck.getNextCard());
        aPlayer.SetHand(deck.getNextCard(), deck.getNextCard());
        gDisplay.setP1(hPlayer.getCard(0));
        gDisplay.setP2(hPlayer.getCard(1));

        gDisplay.setAi1(aPlayer.getCard(0));
        gDisplay.setAi2(aPlayer.getCard(1));

        gState = OperatorState.RUNNING;

         stateValue = 0;

        firstRound();
        gDisplay.repaint();
       
        // CLEAR HANDS OF PLAYERS.
    }

    /**
     * resets gamestate to defaults
     */
    public void reset()
    {

        gState = OperatorState.FINISHED;
        turnChecker = 1;
        hPlayer.setMoney(500);
        aPlayer.setMoney(500);
        pot = 0;
    }

    public void setState()
    {

        if (hPlayer.getMoney() < minBet)
        {
            stateValue = 2;
        }

        else if(hPlayer.getMoney() == minBet)
        {
            stateValue = 3;
        }

        else if(hPlayer.getMoney() <= 0)
        {
            System.out.println("state 4 reached");
            stateValue = 4;
        }
        else {

            stateValue = 1;
        }

    }

    public int getState()
    {
        return stateValue;
    }

    public void update()
    {

        // INIT NEW GAME IF ENDED.
        // MAKE FUNCTION TO RESET.
        if (gState == OperatorState.FINISHED)
        {
            newGame();
              //gState = OperatorState.RUNNING;
              return;
        }

         System.out.println(roundNum);

        //setting up basic start state
        //giving hole cards and default money for each player

        //turn 1


        if(roundNum == 0)
        {
            firstRound();
            System.out.println("first round");

            //roundNum = 1;
           // return;


        }

         if(isEven(turnChecker) && roundNum == 0)
         {

             roundNum = 1;
            //setState();
             //gameFinished();
             return;
         }
         else if (!isEven(turnChecker) && roundNum == 0) {

             roundNum = 1;
         }

         if (roundNum == 1)
        {
            secondRound();
             System.out.println("second round");
             roundNum = 2;

            return;
        }
        else if (roundNum == 2)
        {
            thirdRound();
             System.out.println("third round");
             roundNum = 3;
            return;
        }
        else if (roundNum == 3)
        {
        fourthRound();
         System.out.println("fourth round");
        roundNum = 4;
        return;
        }

        // check for raise or fold
       if
       (HandEvaluator.compareHands(aPlayer.getMyHand(), hPlayer.getMyHand()) == aPlayer.getMyHand())  //if AI winds
        {
            aPlayer.setMoney(aPlayer.getMoney() + pot);
            //pot = 0;
            gameFinished();
        }
       else if
       (HandEvaluator.compareHands(aPlayer.getMyHand(), hPlayer.getMyHand()) == hPlayer.getMyHand())
       {


        hPlayer.setMoney(hPlayer.getMoney() + pot);
        //pot = 0;
        gameFinished();
         
       }

       else
       {
             int halfPot = pot /2;
             aPlayer.setMoney(aPlayer.getMoney() + halfPot);
             hPlayer.setMoney(hPlayer.getMoney() + halfPot);
             pot = 0;
             System.out.println("draw");

             gState = OperatorState.FINISHED;
       }

         






    }

    public void firstRound()
    {
        stateValue = 1;
        setSmallBlind();
       // doATurn();
     //   hPlayer.
    }

    public void secondRound()
    {
        theFlop();
        doATurn();
    }

    public void thirdRound()
    {
        theTurn();
        doATurn();
    }

    public void fourthRound()
    {
        theRiver();
        doATurn();
    }


 

    public void setSmallBlind()
    {
        //initial small blind
        if (isEven(turnChecker))
        {
            hPlayer.setMoney(hPlayer.getMoney() - 10);   //taking small blind away
           // playTurn(aPlayer, hPlayer);
        }
        else
        {
            aPlayer.setMoney(aPlayer.getMoney() - 10);   //taking small blind away

             //playTurn(hPlayer, aPlayer);
        }
        pot = pot + 10;    //paying in small blind
     // gDisplay.repaint();
System.out.println("small blind set");
        // BUSINESS
        

        // CHECK ENDED UPDATE DISPLAY ALSO.

    //    if (false) { // IF GAME FINISHED

  //          finishGame();
     //       gState = OperatorState.FINISHED;
       // }

        turnChecker++;
    }

    private void doATurn()
    {
        if (isEven(turnChecker)) //if not the player who paid the blind aPlayer plays first on even turns
        {
           
            playTurn(aPlayer, hPlayer);
            gDisplay.repaint();
            System.out.println("a players turn");
            
            // if (aPlayer.getAction() != Player.Action.FOLD)
            // {
            playTurn(hPlayer, aPlayer);
            System.out.println("h players turn");
            gDisplay.repaint();
            // }
             
            
        }
        else  //if not the player who paid the blind hPlayer plays first on odd turns
        {
            playTurn(hPlayer, aPlayer);
            gDisplay.repaint();
            System.out.println("h players turn");
            playTurn(aPlayer, hPlayer);
            System.out.println("a players turn");
            gDisplay.repaint();
            
        }
        setState();
    }

    private void playTurn(Player fir, Player sec)
    {
        switch (fir.getAction())
        {
            case RAISE:                //if choosing to raise
             //   if (fir.getRaise() > minBet) // if raise is large enough
           //     {
                    minBet = fir.getRaise();    //set the mimimum bet
                    pot = pot + fir.getRaise();   // adds the raise to the pot
                    fir.setMoney(fir.getMoney() - fir.getRaise());    //remove raise amount from player money
                    System.out.println("raise");
         //      }
                break;

            case FOLD:
                sec.setMoney(sec.getMoney() + pot); //giving winner the pot
                pot = 0;
                System.out.println(" second player moneys =" + sec.getMoney());
             //   System.out.println(sec.winStatment());
                gameFinished();
           //     gState = OperatorState.FINISHED;

                break;

            case BET:
                fir.setMoney(fir.getMoney() - minBet);    // take away min amount neded to call
                pot = pot + minBet;
                break;

            //	case CHECK :  NOT NEEDED AS CHECKING DOESNT RLY DO ANYTHING JUST MOVES GAME ALONG

        }

        //begining second round
         //the flop dealing out three community cards to the table hand,and then into both players hands

    }

    public void theFlop()  // places the first three cards on the table
    {
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
        tableHand.addCard(deck.getNextCard());
        gDisplay.setT4(tableHand.getCard(3));
        hPlayer.givCard(tableHand.getCard(3));
        aPlayer.givCard(tableHand.getCard(3));
        gDisplay.repaint();

    }

     public void theRiver() // places the last card on the table
     {
      tableHand.addCard(deck.getNextCard());
      gDisplay.setT5(tableHand.getCard(4));
       hPlayer.givCard(tableHand.getCard(4));
       aPlayer.givCard(tableHand.getCard(4));
       gDisplay.repaint();
     }



    public static boolean isEven(int num)
    {

        return num % 2 == 0;
    }

    public AiPlayer getAIPlayer() {
        return aPlayer;
    }

    public int getPot() {
        return pot;
    }


    public void gameFinished()
    {
        if ( aPlayer.getAction() == Player.Action.FOLD)
        {
            System.out.println("you win");
        }
        else
        {
            System.out.println("computer wins");
        }
        pot = 0;
         gState = OperatorState.FINISHED;
        newGame();
        
    }

}
 
