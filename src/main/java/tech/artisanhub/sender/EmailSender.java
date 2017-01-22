package tech.artisanhub.sender;

import com.sendgrid.*;
import org.xml.sax.SAXException;
import tech.artisanhub.fileHandler.XMLParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class EmailSender {
    public static boolean sendEmail(String toEmail,String emailSubject, String emailContent) throws IOException, SAXException, ParserConfigurationException {

        Email from = new Email(XMLParser.getSenderEmail());
        String subject = emailSubject;
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", emailContent);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(XMLParser.getEmailApiKey());
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
