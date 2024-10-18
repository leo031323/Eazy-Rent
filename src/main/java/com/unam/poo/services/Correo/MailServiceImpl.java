package com.unam.poo.services.Correo;

import java.util.List;

import com.unam.poo.models.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unam.poo.repository.MailRepository;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    MailRepository mailRepository;

    @Override
    public List<Mail> findAll() {
        return mailRepository.findAll();
    }

    @Override
    public void deleteCorreoById(Long id) {
        mailRepository.deleteById(id);
    }

    @Override
    public Mail getCorreoById(Long id) {
        return mailRepository.findById(id).orElse(null);
    }

    @Override
    public Mail saveCorreo(Mail mail) {
        return mailRepository.save(mail);
    }

    @Override
    public Mail getCorreoByMail(String mail) {
        for (Mail correo : mailRepository.findAll()) {
            if (correo.getUser().getMail().equals(mail)){
                return correo;
            }
        }
        return null;
    }
    
}
