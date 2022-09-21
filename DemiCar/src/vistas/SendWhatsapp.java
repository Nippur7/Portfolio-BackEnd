package vistas;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendWhatsapp {
   // Replace these placeholders with your Account Sid and Auth Token
   public static final String ACCOUNT_SID = "AC7b418b13096780ec9d609e35ed168338";
   public static final String AUTH_TOKEN = "45fb16774363ba05793e0f312a30f2c6";

   public static void main(String[] args) {
       Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
       Message message = Message.creator(
               new com.twilio.type.PhoneNumber("whatsapp:+15005550006"),
               new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
               "Hello from your friendly neighborhood Java application!")
           .create();
   }



}
