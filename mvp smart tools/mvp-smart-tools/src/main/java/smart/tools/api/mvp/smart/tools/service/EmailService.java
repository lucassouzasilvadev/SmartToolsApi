package smart.tools.api.mvp.smart.tools.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendEmail(SimpleMailMessage msg);
}
