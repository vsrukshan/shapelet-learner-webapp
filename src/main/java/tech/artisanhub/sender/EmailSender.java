package tech.artisanhub.sender;

import com.sendgrid.*;

import java.io.IOException;

public class EmailSender {
    public static boolean sendEmail(String toEmail, String fromEmail, String emailSubject, String emailContent){

        Email from = new Email(fromEmail);
        String subject = emailSubject;
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", emailContent);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();

           try {
               request.method = Method.POST;
               request.endpoint = "mail/send";
               request.body = mail.build();
               Response response = sg.api(request);
               System.out.println(response.statusCode);
               System.out.println(response.body);
               System.out.println(response.headers);
           }catch (IOException ex){
               return false;
           }
           return true;
    }
}
