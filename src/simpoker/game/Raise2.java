///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package simpoker.game;
//
///**
// *
// * @author Josh
// */
//public class Raise2 
//{
//    
//     case RAISE:
//                    if (fir.getRaise() >= minBet && fir.getMoney() >= minBet)   // if raise is large enough and player has enough money
//                    {
//                        raiseDif = fir.getRaise() - minBet;              // sets raise dif to the different between the last min bet and the new one after raise
//                        minBet = fir.getRaise();                         //sets minbet to the new amount raised
//                        fir.setMoney(fir.getMoney() - fir.getRaise());  //takes raise off player
//                        pot = pot + fir.getRaise();                    // add raise to pot
//                        
//                    }
//                    else if (fir.getMoney() < minBet)             //if player doesnt have enough money
//                    {
//                        update(8); // have lost game
//                        return;
//                    } 
//                    else if (fir.getRaise() < minBet)       // if player raise isnt big enough
//                    {
//                        return; // should never reach here as AI does enough raise human just gets drop box
//                    }
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    case RAISE:
//
//                    if (sec.getRaise() >= minBet && sec.getMoney() >= minBet) {
//                        raiseDif = sec.getRaise() - minBet;
//                        minBet = sec.getRaise();
//                        sec.setMoney(sec.getMoney() - sec.getRaise());  //takes raise off
//                        pot = pot + sec.getRaise();
//
//                        if (raiseDif > 0 && fir instanceof AiPlayer) { // AI NEEDS TO BE TOLD IT HAS TO MEET RAISE.
//
//                            aPlayer.meetRaise(); // DECIDES IF IT WANTS TO MEET OR FOLD
//                            update(5);
//                            return;
//                        } else {
//                            update(10);
//                            return;
//                        }
//
//                    } else if (sec.getMoney() < minBet) {
//
//                        update(8); // have lost game
//                        return;
//                    }
//                    else if (sec.getRaise() < minBet) {
//
//                    if (sec instanceof AiPlayer) { // AI NEEDS TO BE TOLD IT HAS TO MEET RAISE.
//
//
//                        aPlayer.meetRaise();
//                                                          // DECIDES IF IT WANTS TO MEET OR FOLD
//                        update(5);
//                        return;
//                    }
//                    else
//                    {
//                    update(10);
//                    return;
//                    }
//    
//}
