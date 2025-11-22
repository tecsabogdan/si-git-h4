package ro.scoalainformala.tema;

public class Message {
    private final String phoneNumber;
    private final String content;

    public Message(String phoneNumber, String content) {
        this.phoneNumber = phoneNumber;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{to='" + phoneNumber + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
