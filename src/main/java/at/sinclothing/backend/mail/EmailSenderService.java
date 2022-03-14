package at.sinclothing.backend.mail;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Map;

@Service("emailSenderService")
public class EmailSenderService {

    private final JavaMailSender javaMailSender;

    private final SpringTemplateEngine thymeleafTemplateEngine;

    /*
    @Value("classpath:/mail-logo.png")
    private Resource resourceFile;*/

    public EmailSenderService(JavaMailSender javaMailSender, SpringTemplateEngine thymeleafTemplateEngine) {
        this.javaMailSender = javaMailSender;
        this.thymeleafTemplateEngine = thymeleafTemplateEngine;
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

    public void sendMessageUsingThymeleafTemplate(
            String to, String subject, Map<String, Object> templateModel)
            throws MessagingException {

        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);

        String htmlBody = thymeleafTemplateEngine.process("rechnung.html", thymeleafContext);

        sendHtmlMessage(to, subject, htmlBody);
    }

    private void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("noreply@sin-clothing.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        //helper.addInline("attachment.png", resourceFile);
        javaMailSender.send(message);
    }

}

