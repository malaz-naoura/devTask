package com.safee.devtask.services.mail;

public interface EmailService {

    void sendEmail(String to, String subject, String text);
}
