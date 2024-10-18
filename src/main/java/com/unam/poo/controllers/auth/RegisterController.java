package com.unam.poo.controllers.auth;

import com.unam.poo.dto.UsuarioDto;
import com.unam.poo.models.City;
import com.unam.poo.models.Mail;
import com.unam.poo.models.Photo;
import com.unam.poo.models.User;
import com.unam.poo.security.enums.RoleName;
import com.unam.poo.security.modelo.Role;
import com.unam.poo.security.service.RolService;
import com.unam.poo.services.UsuarioService;
import com.unam.poo.services.Ciudad.CiudadService;
import com.unam.poo.services.Correo.MailService;
import com.unam.poo.services.Foto.FotoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/register")
@Controller
public class RegisterController {

    @Autowired
    UsuarioService usuarioService;
 
    public RegisterController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    @Autowired
    CiudadService ciudadService;
    
    @Autowired
    FotoService fotoService;

    @Autowired
    MailService mailService;

    @GetMapping ("/authRegister")
    public String registerload(Model model) {
        List<City> ciudades = ciudadService.findAll();
        model.addAttribute("ciudades", ciudades);
        return "authRegister";
    }

    @PostMapping("/newRegister")
    public String register(Model model, @Validated @ModelAttribute("UsuarioDto") UsuarioDto usuarioDto, HttpServletRequest request, HttpServletResponse response, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            //aca deberia ir una pagina de error o algo xd
          return "authRegister";
        } 
        try {
            User user = new User();
            if (usuarioDto.getNombre()!="" && usuarioDto.getApellido() != "" && usuarioDto.getCorreo() != ""){
                if (usuarioDto.getDni() > 10000000L){
                    if (usuarioDto.getContraseña().length() > 7 && usuarioDto.getContraseña().length() < 17){                   
                        City city = ciudadService.getCiudadById(usuarioDto.getCiudad());
                        System.out.println(city);
                        user.setCity(city);
                        user.setName(usuarioDto.getNombre());
                        user.setLastName(usuarioDto.getApellido());
                        user.setPhone(usuarioDto.getTelefono());
                        user.setDescription("¡Ingrese una descripcion!");
                        user.setMail(usuarioDto.getCorreo());
                        user.setDni(usuarioDto.getDni());
                        user.setPassword(passwordEncoder.encode(usuarioDto.getContraseña()));
                        
                        Set<Role> roles = new HashSet<>();
                        roles.add(rolService.getByRolNombre(RoleName.ROL_USER).get());
                        user.setRoles(roles); 
                        
                        Photo photo = new Photo();
                        photo.setUser(user);
                        photo.setProfile("../assets/img/pp.jpeg");
                        photo.setFront("../assets/img/bgdep.jpeg");
                        fotoService.saveFoto(photo);
                        user.setPhoto(photo);

                        Mail mail = new Mail();
                        mail.setUser(user);
                        mailService.saveCorreo(mail);

                        System.out.println("Registrando...");
                        usuarioService.saveUsuario(user);
                        System.out.println("Registro exitoso.");
                        response.sendRedirect(request.getContextPath() + "/login");
                        return "authLogin";
                    }else{
                        System.out.println("ERROR: La contraseña debe ser mayor a 8 caracteres y menor a 16 caracteres");
                        model.addAttribute("mensaje", "ERROR: La contraseña debe ser mayor a 8 caracteres y menor a 16 caracteres");
                        return "error";
                    }                
                }else{
                    System.out.println("ERROR: El valor del DNI debe ser un numero valido mayor a 10000000");
                    model.addAttribute("mensaje", "El valor del DNI debe ser un numero valido mayor a 10000000");
                    return "error";
                }
            }else{
                System.out.println("ERROR: Debe especificar un valor para nombre, apellido y correo");
                model.addAttribute("mensaje", "Debe especificar un valor para nombre, apellido y correo");
                return "error";
            } 
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            model.addAttribute("mensaje", e.getMessage());
            return "error";
        }
        
    }

}
