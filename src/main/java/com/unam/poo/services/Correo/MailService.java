package com.unam.poo.services.Correo;

import java.util.List;

import com.unam.poo.models.Mail;

public interface MailService {
    List<Mail> findAll();
    void deleteCorreoById(Long id);
    Mail getCorreoById(Long id);
    Mail getCorreoByMail(String correo);
    Mail saveCorreo(Mail mail);
}
