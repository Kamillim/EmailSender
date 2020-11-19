package de.Data4Life.emailService;

import java.util.List;

public interface EmailService {

    public void sendEmail(List<String> listOfEmails) ;

    public void sendEmail(String email);
}
