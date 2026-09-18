@FunctionalInterface
interface Notification {
    abstract void send(String m);

}

interface Urgent {
    default void urg() {
        System.out.println("Urgent message");
    }

}

class Email implements Notification {
    public void send(String mess) {
        System.out.println("Email send:" + mess);
    }

}

class UrgEmail implements Notification, Urgent {
    public void send(String mess) {
        urg();
        System.out.println("Email send:" + mess);

    }
}

public class Notification_Sender {
    public static void main(String[] args) {
        Notification[] noti = { new Email(), new UrgEmail() };
        String mess = "Ansh";
        for (Notification n : noti) {

            n.send(mess);

        }

    }

}