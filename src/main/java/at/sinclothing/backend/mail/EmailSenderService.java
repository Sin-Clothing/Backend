package at.sinclothing.backend.mail;

import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("emailSenderService")
public class EmailSenderService {
    private final JavaMailSender javaMailSender;

    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * this method actually sends the email
     *
     * @param email SimpleMailMessage
     */
    @Async
    public void sendEmail(SimpleMailMessage email) throws MailAuthenticationException {
        javaMailSender.send(email);
    }

}

