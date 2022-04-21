package io.github.phatnt95.todolistapp.service.email;

/**
 * @author phatnt
 * @discription
 */
public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}
