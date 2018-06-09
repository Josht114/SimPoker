/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on 29-Feb-2012, 15:08:21
 */

package simpoker.gui;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import simpoker.game.GameOperator;
import simpoker.game.GameOperator2;
import simpoker.game.player.Player.Action;

/**
 *
 * @author Josh
 */

//button 1 fold
// button 2 raise
// button 3 new game
// button 4 reset
// button 5 bet
// button 6 match bet




public class MainWindow extends javax.swing.JFrame {

    // FIELDS
    private GameOperator2 operator;

    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        setResizable(false);

      
    }

    private void updateScores() {

        money.setText( "" +operator.getHumanPlayer().getMoney());
        pot.setText("" + operator.getPot());
        opponentMoney.setText("" + operator.getAIPlayer().getMoney());
     //   minBet.setText("" + operator.getMinBet());

    }


    private void stateChecker()
    {

        // state 1 reset games clears hands
     //   System.out.println("GUI State: " + operator.getState());
        if (operator.getState() == 1)
        {
            //System.out.println("stare 1");
            // can only do start game button
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(true);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);

        }
        // state 2 deals hole hards, sets small blind
        else if (operator.getState() == 2)
        {
            //System.out.println("stare 2");
            // deal hole cards and setting small blind no imput needed
            jButton1.setEnabled(true);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(false);
            
            operator.update();
            stateChecker();
            //state 3 matches small blind
        }
        else if (operator.getState() == 3)
        {
            //System.out.println("stare 3");
            // can bet, matching small blind or fold
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(true);
            jButton5.setEnabled(false);
            jButton6.setEnabled(true);

            if (operator.whoGoesFirst() == operator.getHumanPlayer()) {

                operator.update();
                stateChecker();
            }

        }
        // state 4 does the flop
        else if (operator.getState() == 4)
        {
            //System.out.println("stare 4");
            // does the flop no input needed
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(true);
            jButton5.setEnabled(false);
                jButton6.setEnabled(false);
        }
        // state 5 plays a turn
        else if (operator.getState() == 5)
        {
            // System.out.println("stare 5");
            // plays a turn
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(false);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(false);
            jComboBox1.removeAllItems();

            for (int i = operator.getMinBet(); i < operator.getHumanPlayer().getMoney(); i +=10)
            {
                 jComboBox1.addItem(""+ (i + GameOperator2.MIN_BET));
            }
        }
         // state does "the turn"
         else if (operator.getState() == 6)
        {
             //System.out.println("stare 6");
            // does the turn
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(true);
            jButton5.setEnabled(false);
                jButton6.setEnabled(false);
        }
           // state 7 does the river
         else if (operator.getState() == 7)
        {
             //System.out.println("stare 7");
            // does the river
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(true);
            jButton5.setEnabled(false);
                jButton6.setEnabled(false);
        }
         // end of round
         else if (operator.getState() == 8)
        {
             //System.out.println("stare 8");
            // game has ended evaluates hands
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(true);
            jButton5.setEnabled(false);
                jButton6.setEnabled(false);
            updateScores();

            String message = "";

            if (operator.getWhoWon() == null) {

                message = "its a draw!";
            }
            else {

                message = operator.getWhoWon().winStatment();
            }
            
            JOptionPane.showMessageDialog(this, message, "End of Round", JOptionPane.INFORMATION_MESSAGE);
            operator.reset();

            stateChecker();
         }

        // end of game
         else if (operator.getState() >= 9)
         {
        jComboBox1.setEnabled(false);
        jButton6.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
       jButton5.setEnabled(false);
    //    jTextField1.setEnabled(false);  NOT NEEDED
        ((GameDisplay)displayPanel).resetGame();
         JOptionPane.showMessageDialog(this, operator.getWhoWon().winStatment(), "end of game", JOptionPane.INFORMATION_MESSAGE);
        displayPanel.repaint();
      

         }
        
         else 
         {
             System.out.println("waiting");
         }

        updateScores();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayPanel = new GameDisplay();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        money = new javax.swing.JLabel();
        pot = new javax.swing.JLabel();
        opponentMoney = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SimPoker");
        setName("fold button"); // NOI18N

        displayPanel.setBackground(new java.awt.Color(0, 153, 0));
        displayPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Test(evt);
            }
        });

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        jButton1.setText("Fold");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Raise");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Raise amount");

        jLabel2.setText("Money:");

        jLabel4.setText("pot value:");

        jLabel5.setText("opponent money:");

        money.setText("0000");

        pot.setText("0000");

        opponentMoney.setText("0000");

        jButton3.setText("Start Game");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reset Game");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Bet");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Match bet");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton2))))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addGap(24, 24, 24))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pot))
                    .addComponent(money)
                    .addComponent(opponentMoney))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(money)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pot)
                                .addComponent(jButton5)
                                .addComponent(jButton6)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(opponentMoney))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// new game
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton4.setEnabled(true);
        jButton3.setEnabled(false);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
      //  jButton5.setEnabled(false);
      //  jTextField1.setEnabled(true);  NOT NEEDED
        operator = new GameOperator2((GameDisplay)displayPanel);
        operator.update();
        stateChecker();
    }//GEN-LAST:event_jButton3ActionPerformed
// reset game
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton3.setEnabled(true);
        jButton4.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton5.setEnabled(false);
        // jTextField1.setEnabled(false);  NOT NEEDED
         ((GameDisplay)displayPanel).resetGame();
         displayPanel.repaint();
         operator = new GameOperator2((GameDisplay)displayPanel);
         updateScores();
    }//GEN-LAST:event_jButton4ActionPerformed
//fold button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        operator.getHumanPlayer().setAction(Action.FOLD);
        operator.update();
         stateChecker();
    }//GEN-LAST:event_jButton1ActionPerformed
// raise button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         operator.getHumanPlayer().setAction(Action.RAISE);
         operator.getHumanPlayer().setRaise(Integer.parseInt((String)jComboBox1.getSelectedItem()));
        operator.update();
        operator.getHumanPlayer().setRaise(0);
         stateChecker();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Test(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Test
        // TODO add your handling code here:
    }//GEN-LAST:event_Test

    // BET button
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         operator.getHumanPlayer().setAction(Action.BET);
         operator.update();
          stateChecker();
    }//GEN-LAST:event_jButton5ActionPerformed

    //match bet button
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        operator.getHumanPlayer().setAction(Action.MATCHBET);
        operator.update();
        stateChecker();
    }//GEN-LAST:event_jButton6ActionPerformed

    // raise amount box
    // amount need to be min bet plus three others each 10 bigger than the last
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
  




    }//GEN-LAST:event_jComboBox1ActionPerformed
//raise text field
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel displayPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel money;
    private javax.swing.JLabel opponentMoney;
    private javax.swing.JLabel pot;
    // End of variables declaration//GEN-END:variables
    
}
