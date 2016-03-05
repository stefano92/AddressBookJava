/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookjava;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 *
 * @author utente
 */
public class AddressBookGUI extends JFrame{
    
    private AddressBookGUI instance = null;
    private JButton addContactButton;
    private JButton searchContactButton;
    private JButton deleteContactButton;
    private JButton addContact;
    private JButton searchContact;

    public JButton getSearchContact() {
        return searchContact;
    }

    public JButton getDeleteContact() {
        return deleteContact;
    }

    public JTextField getInstructionsField() {
        return instructionsField;
    }
    
    public JButton getAddContactButton(){
        return addContactButton;
    }
    
    public JButton getSearchContactButton(){
        return searchContactButton;
    }
    
    public JButton getDeleteContactButton(){
        return deleteContactButton;
    }
    
    public JButton getAddContact(){
        return addContact;
    }
    
    private JButton deleteContact;
    private JTextField instructionsField;
    private Handlers handlersDispatcher = new Handlers(this);
    
    public AddressBookGUI(){
        super("Simple address book with authentication");
        setLayout(new FlowLayout());
        
        instructionsField = new JTextField("Instructions");
        instructionsField.setVisible(false);
        add(instructionsField);
        
        addContactButton = new JButton("Add contact");
        add(addContactButton);
        addContactButton.addActionListener(handlersDispatcher.createHandler("addContact"));
        
        searchContactButton = new JButton("Search contact");
        add(searchContactButton);
        searchContactButton.addActionListener(handlersDispatcher.createHandler("searchContact"));
        
        deleteContactButton = new JButton("Delete contact");
        add(deleteContactButton);
        deleteContactButton.addActionListener(handlersDispatcher.createHandler("deleteContact"));
        
        addContact = new JButton("Add contact");
        add(addContact);
        addContact.setVisible(false);
        
        searchContact = new JButton("Search contact");
        add(searchContact);
        searchContact.addActionListener(handlersDispatcher.createHandler("search"));
        searchContact.setVisible(false);
        
        deleteContact = new JButton("Delete contact");
        add(deleteContact);
        deleteContact.setVisible(false);
    }
    
    public void contactNotFound(){
        JOptionPane.showMessageDialog(null, "The contact is not in your address book", "Contact not found", JOptionPane.ERROR_MESSAGE);
        searchContact.setVisible(false);
        deleteContact.setVisible(false);
        addContactButton.setVisible(true);
        searchContactButton.setVisible(true);
        deleteContactButton.setVisible(true);
        instructionsField.setVisible(false);
    }
}
