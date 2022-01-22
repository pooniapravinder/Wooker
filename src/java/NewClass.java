
import hibernate.mapping.Messages;
import hibernate.mapping.Usermessages;
import hibernate.query.chat.SaveMessages;

public class NewClass {

    public static void main(String[] args) {
        Usermessages newMessage;
        Messages message;
        SaveMessages insertMessage = new SaveMessages();
        for (int x = 0; x < 200000; x++) {
            newMessage = new Usermessages("1533257729164_344012", 1,System.currentTimeMillis(), 1, 2, false, false, false, false, 0, 0, System.currentTimeMillis(), 0);
            message = new Messages(newMessage, "Hiiiiiiii", null, null, null, null);
            insertMessage.InsertUserMessage(newMessage);
            insertMessage.InsertMessage(message);
        }

    }
}
