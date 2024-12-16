package app.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import app.Modele.UserInfo;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Service
public class EmailService 
{

    final Configuration configuration;
    final JavaMailSender javaMailSender;

    public EmailService(Configuration configuration, JavaMailSender javaMailSender) 
    {
        this.configuration = configuration;
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(UserInfo user,String object) throws MessagingException, IOException, TemplateException 
    {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(object);
        helper.setTo(user.getEmail());
        String emailContent = getEmailContent(user);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }

    String getEmailContent(UserInfo user) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
       configuration.getTemplate("email.html").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}