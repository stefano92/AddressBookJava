/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookjava;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author utente
 */
public class Handlers {
    
    private enum Mode {ADD_CONTACT, SEARCH_CONTACT, DELETE_CONTACT};
    private Mode mode;
            
    AddressBookGUI addressBookGUI;
    AddressBookController addressBookController;
    
    public Handlers (AddressBookGUI addressBookGUI){
        this.addressBookGUI = addressBookGUI; 
        addressBookController = new AddressBookController(addressBookGUI);
    }
    
    public Mode getMode(){
        return this.mode;
    }
    
    public void setMode(Mode mode){
        this.mode = mode;
    }
    
    public ActionListener createHandler(String mode){
        switch(mode){
                case "addContact": return new addContactButtonHandler();
                case "searchContact": return new searchContactButtonHandler();
                case "removeContact": return new deleteContactButtonHandler();
                case "add": return new addContactHandler();
                case "search": return new searchContactHandler();
                default: return null;
        }
    }
     
    private class addContactButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            addressBookGUI.setTitle("Add a new contact");
            addressBookGUI.getAddContactButton().setVisible(false);
            addressBookGUI.getSearchContactButton().setVisible(false);
            addressBookGUI.getDeleteContactButton().setVisible(false);
            addressBookGUI.getSearchContact().setVisible(false);
            addressBookGUI.getAddContact().setVisible(true);
            addressBookGUI.getInstructionsField().setVisible(true);
            addressBookGUI.getInstructionsField().setText("Insert here the nickname");
            addressBookGUI.getContactName().setVisible(true);
            addressBookGUI.getContactName().setText("Insert here the new contact information");
            setMode(Mode.ADD_CONTACT);
        }
    }
    
    private class searchContactButtonHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            addressBookGUI.setTitle("Search contact");
            addressBookGUI.getAddContactButton().setVisible(false);
            addressBookGUI.getSearchContactButton().setVisible(false);
            addressBookGUI.getDeleteContactButton().setVisible(false);
            addressBookGUI.getAddContact().setVisible(false);
            addressBookGUI.getContactName().setVisible(false);
            addressBookGUI.getSearchContact().setVisible(true);
            addressBookGUI.getInstructionsField().setText("Insert here the nickname");
            addressBookGUI.getInstructionsField().setVisible(true);
            setMode(Mode.SEARCH_CONTACT);
        }
    }
   
    private class deleteContactButtonHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            addressBookGUI.setTitle("Delete contact");
            addressBookGUI.getAddContactButton().setVisible(false);
            addressBookGUI.getSearchContactButton().setVisible(false);
            addressBookGUI.getDeleteContactButton().setVisible(false);
            addressBookGUI.getSearchContact().setVisible(false);
            addressBookGUI.getAddContact().setVisible(false);
            addressBookGUI.getContactName().setVisible(false);
            addressBookGUI.getDeleteContact().setVisible(true);
            addressBookGUI.getInstructionsField().setVisible(true);
            addressBookGUI.getInstructionsField().setText("Insert here the nickname of the contact to delete");
            setMode(Mode.DELETE_CONTACT);
        }
    }
    
    private class searchContactHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            String nickname = addressBookGUI.getInstructionsField().getText();
            addressBookController.searchContact(nickname);
        }
    }
    
    private class addContactHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            String nickname = addressBookGUI.getInstructionsField().getText();
            String data = addressBookGUI.getContactName().getText();
            addressBookController.addContact(nickname, data);
        }
    }
}

