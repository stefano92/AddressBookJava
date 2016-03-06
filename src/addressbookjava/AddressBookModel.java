/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookjava;

import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author utente
 */
public class AddressBookModel {
    
    public enum Status {ERROR_NOT_EXISTING_CONTACT, ERROR_ALREADY_EXISTING_CONTACT, CONTACT_CORRECTLY_ADDED, CONTACT_CORRECTLY_DELETED};
    
    private Map<String, String> addressBook = new HashMap<String, String>();
    
    public Map<String, String> getAddressBook() {
        return addressBook;
    }
    
    public Status newContact (String nickname, String data){
        if(addressBook.containsKey(nickname))
            return Status.ERROR_ALREADY_EXISTING_CONTACT;
        addressBook.put(nickname, data);
        return Status.CONTACT_CORRECTLY_ADDED;
    }
    
    public String getContact (String nickname){
        if(!addressBook.containsKey(nickname))
            return String.valueOf(Status.ERROR_NOT_EXISTING_CONTACT);
        return addressBook.get(nickname);
    }
    
    public Status addContact (String nickname, String data) {
        String status = getContact(nickname);
        if(!status.equals(String.valueOf(Status.ERROR_NOT_EXISTING_CONTACT)))
            return Status.ERROR_ALREADY_EXISTING_CONTACT;
        else {
            addressBook.put(nickname, data);
            return Status.CONTACT_CORRECTLY_ADDED;
        }
    }
}
