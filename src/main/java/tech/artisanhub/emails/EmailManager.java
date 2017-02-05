package tech.artisanhub.emails;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import tech.artisanhub.fileHandler.FileContentReader;

/**
 * The EmailSender class contains the configurations and sends the emails to the relevant users.
 */
public class EmailManager {
    private static final Log LOG = LogFactory.getLog(EmailManager.class);


    /**
     * This method configures the needed parameters to configure the email to be sent to the tenant.
     *
     * @param receiptEmail email sent to
     */
    public static void configureEmail(String receiptEmail) {
        FileContentReader reader = new FileContentReader();
        String emailFile = "EmailNotification";
        String emailSubject = "Shapelet Generation has been completed";
        String emailMessage = reader.fileReader(emailFile);
        sendEmail(receiptEmail, emailSubject, emailMessage);

        LOG.info("Email Notification sent to " + receiptEmail);
    }

    public static void sendEmail(String recepient, String subject, String messageBody) {

        //Retrieving the mail properties
        String port = "587";
        String host = "smtp.gmail.com";
        final String emailAddress = "nipunaprashan99@gmail.com";
        final String emailPassword = "19920613";

        //Setting the email properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAddress, emailPassword);
            }
        });
        try {
            //constructing the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));
            message.setSubject(subject);
            message.setContent(messageBody, "text/html");
            //Checking if the email contents is empty or not
            if (" ".equalsIgnoreCase(messageBody)) {
                String errorMessage = "Error sending email. Email content is empty";
                LOG.error(errorMessage);
            } else {
                message.saveChanges();
                Transport.send(message);
            }
        } catch (MessagingException e) {
            String errorMessage = "Error sending email to " + recepient + "";
            LOG.error(errorMessage, e);
        }
    }

}
