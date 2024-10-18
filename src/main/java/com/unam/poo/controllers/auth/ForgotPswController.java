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

import com.unam.poo.services.UsuarioService;
import com.unam.poo.services.Correo.MailServiceImpl;
import com.unam.poo.services.SpringMailSender.MailSenderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/forgotpsw")
public class ForgotPswController {

    @Autowired
    MailSenderService emailSender;
    
    @Autowired
    UsuarioService uService;

    @Autowired
    MailServiceImpl mailService;

    @Autowired
    PasswordEncoder passwordEncoder;
 

    @GetMapping("/")
    public String forgotpswload() {
        return "authForgotPsw";
    } 

    @PostMapping("/enviarCodigo")
    public String enviarCodigo(Model model, @RequestBody String correo, HttpServletRequest request, HttpServletResponse response){
        try {
            correo = correo.replace("%40", "@");
            String arr[] = correo.split("=");
            correo = arr[1];
            System.out.println(correo); 
            
            String codigo = UUID.randomUUID().toString();

            String toInternetAdress = correo;
            String subject = "Codigo para reestablecer contraseña";
            String body = codigo;

            emailSender.sendCustomMail(toInternetAdress, subject, body);

            Mail aux = mailService.getCorreoByMail(correo);
            aux.setCode(codigo);
            mailService.saveCorreo(aux);
            System.out.println("Codigo: " + codigo);
            response.sendRedirect(request.getContextPath() + "/forgotpsw/");
            return "authForgotPsw";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            model.addAttribute("mensaje", e.getMessage());
            return "error";
        }
        
    }
   
    @PostMapping("/reestablecerPassword")
    public String reestablecerPassword(Model model, @RequestBody String correo, @RequestBody String codigo, @RequestBody String password, HttpServletRequest request, HttpServletResponse response){
        try { 
            correo = correo.replace("%40", "@");
            String arr[] = correo.split("=");
            correo = arr[1]; //correo@gmail.com&codigo
            correo = correo.replace("&codigo", "");

            codigo = arr[2]; //codigo&password
            codigo = codigo.replace("&password", "");

            password = arr[3];

            System.out.println("Mail: " + correo);
            System.out.println("Codigo: " + codigo);
            System.out.println("Contraseña: " + password); 
            if (uService.getUsuarioByCorreo(correo) != null){
                System.out.println("USUARIO ENCONTRADO");
                User user = uService.getUsuarioByCorreo(correo);
                if (user.getPost().getCode().equals(codigo)){
                    user.setPassword(passwordEncoder.encode(password));
                    uService.saveUsuario(user);
                    Mail mail = mailService.getCorreoByMail(correo);
                    mail.setCode("");
                    mailService.saveCorreo(mail);
                    System.out.println("Cambio de contraseña exitoso");
                    response.sendRedirect(request.getContextPath() + "/");
                }else{
                    System.out.println("Codigo incorrecto");
                    model.addAttribute("mensaje", "Codigo incorrecto");
                    return "error";
                }
            }else{
                System.out.println("El correo no se encuentra registrado");
                model.addAttribute("mensaje", "El correo no se encuentra registrado");
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
