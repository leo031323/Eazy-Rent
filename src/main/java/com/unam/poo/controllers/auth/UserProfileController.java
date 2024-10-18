package com.unam.poo.controllers.auth;

import java.net.URLDecoder;
import java.util.List;

import com.unam.poo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unam.poo.dto.LoginDto;
import com.unam.poo.dto.UserDto;
import com.unam.poo.models.City;
import com.unam.poo.services.UserService;
import com.unam.poo.services.Characteristic  Comfort.Characteristic  ComfortService;
import com.unam.poo.services.City.CityService;
import com.unam.poo.services.  Comfort.  ComfortService;
import com.unam.poo.services.Photo.PhotoService;
import com.unam.poo.services.Province.ProvinceService;
import com.unam.poo.services.Publicacion.PublicacionService;
import com.unam.poo.services.Tipo.TipoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
    @RequestMapping("/user")
public class UserProfileController {

    @Autowired
    PublicacionService publicacionService;

    @Autowired
    TipoService tipoService;

    @Autowired
    UserService userService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
      ComfortService   comfortService;

    @Autowired
    Characteristic  ComfortService characteristic  ComfortService;

    @Autowired
    CityService cityService;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PhotoService photoService;

    @GetMapping("/profile")
    public String userProfile(Model model, HttpServletRequest request)
    {
        List<Publication> publicaciones = publicacionService.findAllByStatePublicacion("active");
        publicaciones.addAll(   publicacionService.findAllByStatePublicacion("Alquilado")   );
        publicaciones.addAll(   publicacionService.findAllByStatePublicacion("Desactivado")   );
        List<FeatureComfort> characteristic    Comforts = characteristic  ComfortService.findAll();

        Long idUser = (Long) request.getSession().getAttribute("userId");
        model.addAttribute("user", userService.getUserById(idUser));
        model.addAttribute("publicaciones", publicaciones);
        model.addAttribute("characteristic    Comforts", characteristic    Comforts);

        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        
        return "userProfile";
    }

    @PostMapping("/update")
    public String updateProfile(Model model, @Validated @ModelAttribute("UserDto") UserDto userDto, HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println("DATOS A ACTUALIZAR: ");
            System.out.println("Name: " + userDto.getName());
            System.out.println("Lastname: " + userDto.getLastname());
            System.out.println("Mail: " + userDto.getMail());
            System.out.println("Telephone: " + userDto.getTelephone());
            System.out.println("City ID: " + userDto.getCity());
            System.out.println("Description: " + userDto.getDescription());


            Long idUser = (Long) request.getSession().getAttribute("userId");
            User user = userService.getUserById(idUser);
            System.out.println("User objetivo: " + user);
            
            City city = cityService.getCityById(userDto.getCity());
            System.out.println("City objetivo: " + city);

            System.out.println("Setting city");
            user.setCity(city);
            System.out.println("Setting name");
            user.setName(userDto.getName());
            System.out.println("Setting lastname");
            user.setLastName(userDto.getLastname());
            System.out.println("Setting telephone");
            user.setPhone(userDto.getTelephone());
            System.out.println("Setting description");
            user.setDescription(userDto.getDescription());
            System.out.println("Setting mail");
            user.setMail(userDto.getMail());
            System.out.println("Guardando...");
            userService.saveUser(user);
            System.out.println("Actualizado con exito.");
            response.sendRedirect(request.getContextPath()+"/user/profile");
            return "userProfile";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + ". Causa: " + e.getCause()); 
            model.addAttribute("mensaje", e.getMessage() );
            return "error";
        }
    }

    @PostMapping("/cambiarProfile")
    public String cambiarProfile(Model model, @RequestBody String body, HttpServletRequest request, HttpServletResponse response, BindingResult result) {
        if (result.hasErrors()) { 
            model.addAttribute("mensaje", result.getAllErrors().toString());
            return "error";
        }  
        try {    
            Long idUser = (Long) request.getSession().getAttribute("userId");
            User user = userService.getUserById(idUser);
            if ( user != null){
                Photo photo = user.getPhoto();
                String str = body.replace("imag=", ""); 
                str = URLDecoder.decode(str, "UTF-8");
                System.out.println(str);
                photo.setProfile(str);
                photoService.savePhoto(photo);
            } 
            response.sendRedirect(request.getContextPath() + "/user/profile");
            return "userProfile";             
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            model.addAttribute("mensaje", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/cambiarFront")
    public String cambiarFront(Model model, @RequestBody String body, HttpServletRequest request, HttpServletResponse response, BindingResult result) {
        if (result.hasErrors()) { 
            model.addAttribute("mensaje", result.getAllErrors().toString());
            return "error";
        }  
        try {   
            Long idUser = (Long) request.getSession().getAttribute("userId");
            User user = userService.getUserById(idUser);
            if ( user != null){
                Photo photo = user.getPhoto();
                String str = body.replace("front=", ""); 
                str = URLDecoder.decode(str, "UTF-8");
                System.out.println(str);
                photo.setFront(str);
                photoService.savePhoto(photo);
            } 
            response.sendRedirect(request.getContextPath() + "/user/profile");
            return "userProfile";            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            model.addAttribute("mensaje", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount(Model model, @Validated @ModelAttribute("LoginDto") LoginDto loginDto, HttpServletRequest request, HttpServletResponse response, BindingResult result) {
        if (result.hasErrors()) { 
          return "Error";
        }  
        try { 
            System.out.println("Buscando user");
            User user = userService.getUserByMail(loginDto.getMail().toString());
            System.out.println("Encontrado");
            if (user != null){  
                System.out.println("Mail correcto, verificando password");
                if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
                    //Coinciden entonces:
                    System.out.println("AUTENTICADO: Dando de baja la cuenta...");
                   
                    user.setActive(false);
                    userService.saveUser(user);
                    
                    /* Como en el logout -> */ 
                    request.getSession().removeAttribute("user"); 
                    request.getSession().removeAttribute("autenticado"); 
                    response.sendRedirect(request.getContextPath() + "/");
                    return "welcome"; 
                }else{
                    System.out.println("ERROR: Password incorrecta");
                    model.addAttribute("mensaje", "Password incorrecta");
                    return "error";
                }
            }else{
                System.out.println("ERROR: Mail incorrecto");
                model.addAttribute("mensaje", "Mail incorrecto");
                return "error";
            } 
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            model.addAttribute("mensaje", e.getMessage());
            return "error";
        }
    }

}
