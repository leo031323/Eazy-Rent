package com.unam.poo.controllers.auth;

import com.unam.poo.dto.UserDto;
import com.unam.poo.models.City;
import com.unam.poo.models.Mail;
import com.unam.poo.models.Photo;
import com.unam.poo.models.User;
import com.unam.poo.security.enums.RoleName;
import com.unam.poo.security.modelo.Role;
import com.unam.poo.security.service.RolService;
import com.unam.poo.services.UserService;
import com.unam.poo.services.City.CityService;
import com.unam.poo.services.Mail.MailService;
import com.unam.poo.services.Photo.PhotoService;

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
    UserService userService;
 
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    @Autowired
    CityService cityService;
    
    @Autowired
    PhotoService photoService;

    @Autowired
    MailService mailService;

    @GetMapping ("/authRegister")
    public String registerload(Model model) {
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "authRegister";
    }

    @PostMapping("/newRegister")
    public String register(Model model, @Validated @ModelAttribute("UserDto") UserDto userDto, HttpServletRequest request, HttpServletResponse response, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            //aca deberia ir una pagina de error o algo xd
          return "authRegister";
        } 
        try {
            User user = new User();
            if (userDto.getName()!="" && userDto.getLastname() != "" && userDto.getMail() != ""){
                if (userDto.getDni() > 10000000L){
                    if (userDto.getPassword().length() > 7 && userDto.getPassword().length() < 17){                   
                        City city = cityService.getCityById(userDto.getCity());
                        System.out.println(city);
                        user.setCity(city);
                        user.setName(userDto.getName());
                        user.setLastName(userDto.getLastname());
                        user.setPhone(userDto.getTelephone());
                        user.setDescription("¡Ingrese una description!");
                        user.setMail(userDto.getMail());
                        user.setDni(userDto.getDni());
                        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                        
                        Set<Role> roles = new HashSet<>();
                        roles.add(rolService.getByRolName(RoleName.ROL_USER).get());
                        user.setRoles(roles); 
                        
                        Photo photo = new Photo();
                        photo.setUser(user);
                        photo.setProfile("../assets/img/pp.jpeg");
                        photo.setFront("../assets/img/bgdep.jpeg");
                        photoService.savePhoto(photo);
                        user.setPhoto(photo);

                        Mail mail = new Mail();
                        mail.setUser(user);
                        mailService.saveMail(mail);

                        System.out.println("Registrando...");
                        userService.saveUser(user);
                        System.out.println("Registro exitoso.");
                        response.sendRedirect(request.getContextPath() + "/login");
                        return "authLogin";
                    }else{
                        System.out.println("ERROR: La password debe ser mayor a 8 caracteres y menor a 16 caracteres");
                        model.addAttribute("mensaje", "ERROR: La password debe ser mayor a 8 caracteres y menor a 16 caracteres");
                        return "error";
                    }                
                }else{
                    System.out.println("ERROR: El valor del DNI debe ser un numero valido mayor a 10000000");
                    model.addAttribute("mensaje", "El valor del DNI debe ser un numero valido mayor a 10000000");
                    return "error";
                }
            }else{
                System.out.println("ERROR: Debe especificar un valor para name, lastname y mail");
                model.addAttribute("mensaje", "Debe especificar un valor para name, lastname y mail");
                return "error";
            } 
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            model.addAttribute("mensaje", e.getMessage());
            return "error";
        }
        
    }

}
