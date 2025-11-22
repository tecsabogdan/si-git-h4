package ro.scoalainformala.tema;

public class Main {
        public static void main(String[] args) {
            // Phone phone= new Samsung(); // shouldn't compile
            Phone phone = new SamsungGalaxy6();
            System.out.println("--Adding Contacts--");
            phone.addContact("1", "0754011864", "Marcel", "Popescu");
            phone.addContact("2", "0731527541", "Alin", "Grigorovici");
            phone.addContact("3", "0722564897", "Ioana", "Ionescu");
            System.out.println("----------------------");
            phone.getFirstContact();
            phone.getLastContact();
            phone.getContactList();
            // send a message to the first contact from the previously listed
            // max number of characters - 100
            System.out.println("--Sending Messages--");
            phone.sendMessage("0754011864", "message content");
            phone.sendMessage("0754011864", "message content2");
            phone.sendMessage("0754011864", "message content3");
            phone.sendMessage("0754011864", "N+aFTYG=EUUPOU3xCp9%Y4MG57X$GOdGJ+yhTZGMbNF&sbPzf&!Qsr2E*3x1R=YAuG4w@sq4EzHSny&oWrwRv75X8qqmUp#BFbGE\n");

            System.out.println("--Message History--");
            phone.getMessageHistory("0754011864");
            phone.getFirstMessage("0754011864");
            phone.getSecondMessage("0754011864");

            // make a call to the second contact from the previously listed
            System.out.println("--Phone Calls and History--");
            phone.call("0731527541");
            phone.call("0731527541");
            phone.call("0754011864");
            phone.call("0754011864");
            phone.viewHistory();
            System.out.println("----------------------");
    }
}