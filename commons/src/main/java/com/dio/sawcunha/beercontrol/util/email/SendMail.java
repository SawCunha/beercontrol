package com.dio.sawcunha.beercontrol.util.email;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SendMail {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public String sendMail() {

        try {

//            final MimeMessage mimeMessage = mailSender.createMimeMessage();
//            final MimeMessageHelper message =
//                    new MimeMessageHelper(mimeMessage, true, "UTF-8"); // true = multipart
//
//            message.setSubject("Test Spring Email and Thymeleaf");
//            message.setTo("email@email.com");
//            message.setFrom("email@email.com");
//
//            Context context = new Context();
//            context.setVariable("name", "Nome");
//            context.setVariable("sign", "Nome");
//            context.setVariable("location", "Brazil Minas");
//
//            final String htmlContent = templateEngine.process("notification.html", context);
//
//            message.setText(htmlContent, true); // true = isHtml
//
//            mailSender.send(mimeMessage);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }

}
