package com.richieoscar.flightreservation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender mailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    public void sendItenary(String toAddress, String path) {


        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(toAddress);
            mimeMessageHelper.setSubject("FLIGHT ITENARY");
            mimeMessageHelper.setText("Please find attached Your flight Itenary");
            mimeMessageHelper.addAttachment("Flight Itenary", new File(path));
            logInfo("SendItenary retruns:" +mimeMessage);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logError("Send Itenary return error:" +e);
        }

    }

    private void logInfo(String info) {
        LOGGER.info(info);
    }

    private void logError(String error) {
        LOGGER.error(error);
    }

}
