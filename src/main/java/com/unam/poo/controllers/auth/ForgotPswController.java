package com.unam.poo.controllers.auth;


import java.util.UUID;

import com.unam.poo.models.Mail;
import com.unam.poo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unam.poo.services.UserService;
import com.unam.poo.services.Mail.MailServiceImpl;
import com.unam.poo.services.SpringMailSender.MailSenderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/forgotpsw")
public class ForgotPswController {

    @Autowired
    MailSenderService emailSender;
    
    @Autowired
    UserService uService;

    @Autowired
    MailServiceImpl mailService;

    @Autowired
    PasswordEncoder passwordEncoder;
 

    @GetMapping("/")
    public String forgotpswload() {
        return "authForgotPsw";
    } 

    @PostMapping("/enviarCode")
    public String enviarCode(Model model, @RequestBody String mail, HttpServletRequest request, HttpServletResponse response){
        try {
            mail = mail.replace("%40", "@");
            String arr[] = mail.split("=");
            mail = arr[1];
            System.out.println(mail); 
            
            String code = UUID.randomUUID().toString();

            String toInternetAdress = mail;
            String subject = "Code para reestablecer password";
            String body = code;

            emailSender.sendCustomMail(toInternetAdress, subject, body);

            Mail aux = mailService.getMailByMail(mail);
            aux.setCode(code);
            mailService.saveMail(aux);
            System.out.println("Code: " + code);
            response.sendRedirect(request.getContextPath() + "/forgotpsw/");
            return "authForgotPsw";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            model.addAttribute("mensaje", e.getMessage());
            return "error";
        }
        
    }
   
    @PostMapping("/reestablecerPassword")
    public String reestablecerPassword(Model model, @RequestBody String mail, @RequestBody String code, @RequestBody String password, HttpServletRequest request, HttpServletResponse response){
        try { 
            mail = mail.replace("%40", "@");
            String arr[] = mail.split("=");
            mail = arr[1]; //mail@gmail.com&code
            mail = mail.replace("&code", "");

            code = arr[2]; //code&password
            code = code.replace("&password", "");

            password = arr[3];

            System.out.println("Mail: " + mail);
            System.out.println("Code: " + code);
            System.out.println("Password: " + password); 
            if (uService.getUserByMail(mail) != null){
                System.out.println("USUARIO ENCONTRADO");
                User user = uService.getUserByMail(mail);
                if (user.getPost().getCode().equals(code)){
                    user.setPassword(passwordEncoder.encode(password));
                    uService.saveUser(user);
                    Mail post = mailService.getMailByMail(mail);
                    post.setCode("");
                    mailService.saveMail(post);
                    System.out.println("Cambio de password exitoso");
                    response.sendRedirect(request.getContextPath() + "/");
                }else{
                    System.out.println("Code incorrecto");
                    model.addAttribute("mensaje", "Code incorrecto");
                    return "error";
                }
            }else{
                System.out.println("El mail no se encuentra registrado");
                model.addAttribute("mensaje", "El mail no se encuentra registrado");
                return "error";
            }           
            return "welcome";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            model.addAttribute("mensaje", e.getMessage());
            return "error";
        }
        
    }
}
