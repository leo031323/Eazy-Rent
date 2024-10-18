package com.unam.poo.services.Mail;

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
    public void deleteMailById(Long id) {
        mailRepository.deleteById(id);
    }

    @Override
    public Mail getMailById(Long id) {
        return mailRepository.findById(id).orElse(null);
    }

    @Override
    public Mail saveMail(Mail mail) {
        return mailRepository.save(mail);
    }

    @Override
    public Mail getMailByMail(String mail) {
        for (Mail post : mailRepository.findAll()) {
            if (post.getUser().getMail().equals(mail)){
                return post;
            }
        }
        return null;
    }
    
}
