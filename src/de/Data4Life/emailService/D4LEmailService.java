package de.Data4Life.emailService;

import java.util.List;
import java.util.logging.Logger;

public class D4LEmailService implements EmailService {

    private static final Logger LOGGER = Logger.getLogger(D4LEmailService.class.getName());
    public void sendEmail(List<String> listOfEmails) {
        for (String email : listOfEmails){
            sendEmail(email);
        }
    }

    public void sendEmail(String email) {
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        LOGGER.info( "MAIL SENT TO: "+ email);
    }
}
