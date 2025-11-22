package ro.scoalainformala.tema;

public interface PhoneActions {
    //contact actions
    void addContact(String id, String phoneNumber, String firstName, String lastName);
    void getContactList();
    void getFirstContact();
    void getLastContact();

    //messaging actions
    void sendMessage(String phoneNumber, String messageContent);
    void getFirstMessage(String phoneNumber);
    void getSecondMessage(String phoneNumber);
    void getMessageHistory(String phoneNumber);

    //call actions
    void call(String phoneNumber);
    void viewHistory();
}