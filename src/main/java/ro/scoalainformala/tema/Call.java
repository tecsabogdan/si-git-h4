package ro.scoalainformala.tema;

public class Call {
    private final String phoneNumber;

    public Call(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Call{to='" + phoneNumber + '\'' +
                '}';
    }
}
