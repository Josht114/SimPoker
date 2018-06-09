/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simpoker.game.player;

import simpoker.game.GameOperator2;

/**
 *
 * @author Josh
 */

public class AiPlayer extends Player
{
    //private Action temAc;
 //   double randNumber = Math.random();


    public AiPlayer()
    {
        super();
       // setRaise(GameOperator2.getMinBet() + 10);
        
    }

   
       
   
       
    

    private Action pickAction()
    {
       double randNumber = Math.random();
        
         if(randNumber < 0.33)
        {
              temAc = Action.FOLD;
              System.out.println("COMPUTER FOLDS");
              setRaise(0);
        }
        else if (randNumber > 0.33 && randNumber < 0.66)
        {
            setRaise(20);
              temAc = Action.RAISE;
               System.out.println("COMPUTER raises");
        }
        else
        {
              temAc = Action.BET;
               System.out.println("COMPUTER BETS");
               setRaise(0);
        }
             System.out.println("RETURNING AN ACTION");
            return temAc;


    }


    @Override
    public String winStatment()
    {
      return "Computer has won";

    }

    public void makeDecision(int mBet)
    {
        
 //       temAc = pickAction();
         temAc = Action.RAISE;
         setRaise(mBet + GameOperator2.MIN_BET);
    }

    public void meetRaise(int mBet)
    {
        
         temAc = Action.MATCHBET;
    }

    public void resetAction() {

        temAc = null;
    }
}
