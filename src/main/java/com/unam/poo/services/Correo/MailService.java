package com.unam.poo.services.Mail;

import java.util.List;

import com.unam.poo.models.Mail;

public interface MailService {
    List<Mail> findAll();
    void deleteMailById(Long id);
    Mail getMailById(Long id);
    Mail getMailByMail(String mail);
    Mail saveMail(Mail mail);
}
