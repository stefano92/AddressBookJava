/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookjava;

/**
 *
 * @author utente
 */
public class AddressBookController {
    
    AddressBookModel addressBookModel;
    AddressBookGUI addressBookGUI;
    
    public AddressBookController(AddressBookGUI addressBookGUI){
        addressBookModel = new AddressBookModel();
        this.addressBookGUI = addressBookGUI;
    }
    
    public void searchContact(String nickname){
        String status = addressBookModel.getContact(nickname);
        if(status.equals(String.valueOf(AddressBookModel.Status.ERROR_NOT_EXISTING_CONTACT)))
           addressBookGUI.contactNotFound();
        else
            addressBookGUI.showContactInformation(status);
    }
    
    public void addContact(String nickname, String data) {
        AddressBookModel.Status status = addressBookModel.addContact(nickname, data);
        if (status == AddressBookModel.Status.ERROR_ALREADY_EXISTING_CONTACT)
            addressBookGUI.alreadyExistingContact();
        else
            addressBookGUI.contactCorrecltyAdded();
    }
}
