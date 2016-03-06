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
    private JButton deleteContact;
    private JTextField instructionsField;
    private JTextField contactName;

    public JButton getSearchContact() {
        return this.searchContact;
    }

    public JButton getDeleteContact() {
        return this.deleteContact;
    }

    public JTextField getInstructionsField() {
        return this.instructionsField;
    }
    
    public JButton getAddContactButton(){
        return this.addContactButton;
    }
    
    public JButton getSearchContactButton(){
        return this.searchContactButton;
    }
    
    public JButton getDeleteContactButton(){
        return this.deleteContactButton;
    }
    
    public JButton getAddContact(){
        return this.addContact;
    }
    
    public JTextField getContactName(){
        return this.contactName;
    }
    
    private Handlers handlersDispatcher = new Handlers(this);
    
    public AddressBookGUI(){
        super("Simple address book with authentication");
        setLayout(new FlowLayout());
        
        instructionsField = new JTextField("Instructions");
        instructionsField.setVisible(false);
        add(instructionsField);
        
        contactName = new JTextField("Write here the contact information");
        contactName.setVisible(false);
        add(contactName);
        
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
        addContact.addActionListener(handlersDispatcher.createHandler("add"));
        addContact.setVisible(false);
        
        searchContact = new JButton("Search contact");
        add(searchContact);
        searchContact.addActionListener(handlersDispatcher.createHandler("search"));
        searchContact.setVisible(false);
        
        deleteContact = new JButton("Delete contact");
        add(deleteContact);
        deleteContact.setVisible(false);
    }
    
    public void contactNotFound() {
        JOptionPane.showMessageDialog(null, "The contact is not in your address book", "Contact not found", JOptionPane.ERROR_MESSAGE);
        restoreInitialScreen();
    }
    
    public void showContactInformation(String data) {
        String contactInformation = "Your contact: " + data;
        JOptionPane.showMessageDialog(null, contactInformation, "Contact found", JOptionPane.INFORMATION_MESSAGE);
        restoreInitialScreen();
    }
    
    public void alreadyExistingContact() {
        JOptionPane.showMessageDialog(null, "The contact your are trying to add already exists in your address book", "Contact not added", JOptionPane.ERROR_MESSAGE);
        restoreInitialScreen();
    }
    
    public void contactCorrecltyAdded() {
        JOptionPane.showMessageDialog(null, "Your contact has been correctly added to your addess book", "Contact added", JOptionPane.INFORMATION_MESSAGE);
        restoreInitialScreen();
    }
    
    private void restoreInitialScreen() {
        searchContact.setVisible(false);
        deleteContact.setVisible(false);
        instructionsField.setVisible(false);
        contactName.setVisible(false);
        addContact.setVisible(false);
        deleteContact.setVisible(false);
        addContactButton.setVisible(true);
        searchContactButton.setVisible(true);
        deleteContactButton.setVisible(true);
    }
}
