/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookjava;

import javax.swing.JFrame;
/**
 *
 * @author Stefano D'Alessio
 */
public class AddressBookJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AddressBookGUI addressBook = new AddressBookGUI();
        addressBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addressBook.setSize(350,100);
        addressBook.setVisible(true);
    }
    
}
