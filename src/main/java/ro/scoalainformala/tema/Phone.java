package ro.scoalainformala.tema;

import java.util.*;

public abstract class Phone implements PhoneActions {

    private final String manufacturer;
    private final String model;
    private int batteryLife;
    private final String imei = UUID.randomUUID().toString();

    private String color;
    private String material;

    protected static final int maxMessageLength = 100;
    private static final int messageBatteryConsumption = 1;
    private static final int callBatteryConsumption = 2;

    private final List<Contact> contactList = new ArrayList<>();
    private final List<Call> callHistory = new ArrayList<>();
    private final Map<String, List<Message>> messagesHistory = new HashMap<>();

    public Phone(String manufacturer, String model, int batteryLife) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.batteryLife = batteryLife;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void addContact(String id, String phoneNumber, String firstName, String lastName) {
        Contact newContact = new Contact(id, phoneNumber, firstName, lastName);
        contactList.add(newContact);
        System.out.println("Contact added: " + newContact);
    }

    @Override
    public void getContactList() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts.");
            return;
        }
        System.out.println("Contact List:");
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    @Override
    public void getFirstContact() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts.");
            return;
        }
        System.out.println("First contact: " + contactList.get(0));
    }

    public void getLastContact() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts.");
            return;
        }
        System.out.println("Last contact: " + contactList.get(contactList.size() - 1));
    }

    @Override
    public void sendMessage(String phoneNumber, String content) {
        if (content.length() > maxMessageLength) {
            System.out.println("Message too long! Max length is " + maxMessageLength + " characters.");
            return;
        }
        if (batteryLife < messageBatteryConsumption) {
            System.out.println("Not enough battery to send message.");
            return;
        }
        Message message = new Message(phoneNumber, content);
        messagesHistory.computeIfAbsent(phoneNumber, k -> new ArrayList<>()).add(message);
        batteryLife -= messageBatteryConsumption;
        System.out.println("Sent message: " + message);
        System.out.println("Remaining battery: " + batteryLife + "h");
    }

    @Override
    public void getMessageHistory(String phoneNumber) {
        List<Message> messages = messagesHistory.get(phoneNumber);
        if (messages == null || messages.isEmpty()) {
            System.out.println("No messages for phone number: " + phoneNumber);
            return;
        }
        System.out.println("Message history for " + phoneNumber + ":");
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    @Override
    public void getFirstMessage(String phoneNumber) {
        List<Message> messages = messagesHistory.get(phoneNumber);
        if (messages == null || messages.isEmpty()) {
            System.out.println("No messages for phone number: " + phoneNumber);
            return;
        }
        System.out.println("First message: " + messages.get(0));
    }

    @Override
    public void getSecondMessage(String phoneNumber) {
        List<Message> messages = messagesHistory.get(phoneNumber);
        if (messages == null || messages.size() < 2) {
            System.out.println("Less than 2 messages for phone number: " + phoneNumber);
            return;
        }
        System.out.println("Second message: " + messages.get(1));
    }

    @Override
    public void call(String phoneNumber) {
        if (batteryLife < callBatteryConsumption) {
            System.out.println("Not enough battery to make a call.");
            return;
        }
        Call call = new Call(phoneNumber);
        callHistory.add(call);
        batteryLife -= callBatteryConsumption;
        System.out.println("Made call: " + call);
        System.out.println("Remaining battery: " + batteryLife + "h");
    }

    @Override
    public void viewHistory() {
        if (callHistory.isEmpty()) {
            System.out.println("No calls in history.");
            return;
        }
        System.out.println("Call history:");
        for (Call call : callHistory) {
            System.out.println(call);
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", batteryLifeHours=" + batteryLife +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", imei='" + imei + '\'' +
                '}';
    }
}