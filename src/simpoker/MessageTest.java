/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpoker;

import javax.swing.JOptionPane;

/**
 *
 * @author Josh
 */
public class MessageTest {
    
    public static void main(String[] args) {
        
        System.out.println("HELLO");
        
        int i = JOptionPane.showConfirmDialog(null, "You have been outraised by 20, do you want to meet raise?", "OUT RAISED!", JOptionPane.YES_NO_OPTION);
        
        System.out.println(i);
        System.out.println("GOODBYE!");
    }
}
