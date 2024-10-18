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
import com.unam.poo.dto.UsuarioDto;
import com.unam.poo.models.City;
import com.unam.poo.services.UsuarioService;
import com.unam.poo.services.CaracteristicaComodidad.CaracteristicaComodidadService;
import com.unam.poo.services.Ciudad.CiudadService;
import com.unam.poo.services.Comodidad.ComodidadService;
import com.unam.poo.services.Foto.FotoService;
import com.unam.poo.services.Provincia.ProvinciaService;
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
    UsuarioService usuarioService;

    @Autowired
    ProvinciaService provinciaService;

    @Autowired
    ComodidadService comodidadService;

    @Autowired
    CaracteristicaComodidadService caracteristicaComodidadService;

    @Autowired
    CiudadService ciudadService;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    FotoService fotoService;

    @GetMapping("/profile")
    public String userProfile(Model model, HttpServletRequest request)
    {
        List<Publication> publicaciones = publicacionService.findAllByEstadoPublicacion("activo");
        publicaciones.addAll(   publicacionService.findAllByEstadoPublicacion("Alquilado")   );
        publicaciones.addAll(   publicacionService.findAllByEstadoPublicacion("Desactivado")   );
        List<FeatureComfort> caracteristicaComodidades = caracteristicaComodidadService.findAll();

        Long idUsuario = (Long) request.getSession().getAttribute("userId");
        model.addAttribute("usuario", usuarioService.getUsuarioById(idUsuario));
        model.addAttribute("publicaciones", publicaciones);
        model.addAttribute("caracteristicaComodidades", caracteristicaComodidades);

        List<City> ciudades = ciudadService.findAll();
        model.addAttribute("ciudades", ciudades);
        
        return "userProfile";
    }

    @PostMapping("/update")
    public String updateProfile(Model model, @Validated @ModelAttribute("UsuarioDto") UsuarioDto usuarioDto, HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println("DATOS A ACTUALIZAR: ");
            System.out.println("Nombre: " + usuarioDto.getNombre());
            System.out.println("Apellido: " + usuarioDto.getApellido());
            System.out.println("Mail: " + usuarioDto.getCorreo());
            System.out.println("Telefono: " + usuarioDto.getTelefono());
            System.out.println("City ID: " + usuarioDto.getCiudad());
            System.out.println("Descripcion: " + usuarioDto.getDescripcion());


            Long idUsuario = (Long) request.getSession().getAttribute("userId");
            User user = usuarioService.getUsuarioById(idUsuario);
            System.out.println("User objetivo: " + user);
            
            City city = ciudadService.getCiudadById(usuarioDto.getCiudad());
            System.out.println("City objetivo: " + city);

            System.out.println("Setting city");
            user.setCity(city);
            System.out.println("Setting nombre");
            user.setName(usuarioDto.getNombre());
            System.out.println("Setting apellido");
            user.setLastName(usuarioDto.getApellido());
            System.out.println("Setting telefono");
            user.setPhone(usuarioDto.getTelefono());
            System.out.println("Setting descripcion");
            user.setDescription(usuarioDto.getDescripcion());
            System.out.println("Setting correo");
            user.setMail(usuarioDto.getCorreo());
            System.out.println("Guardando...");
            usuarioService.saveUsuario(user);
            System.out.println("Actualizado con exito.");
            response.sendRedirect(request.getContextPath()+"/user/profile");
            return "userProfile";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + ". Causa: " + e.getCause()); 
            model.addAttribute("mensaje", e.getMessage() );
            return "error";
        }
    }

    @PostMapping("/cambiarPerfil")
    public String cambiarPerfil(Model model, @RequestBody String body, HttpServletRequest request, HttpServletResponse response, BindingResult result) {
        if (result.hasErrors()) { 
            model.addAttribute("mensaje", result.getAllErrors().toString());
            return "error";
        }  
        try {    
            Long idUsuario = (Long) request.getSession().getAttribute("userId");
            User user = usuarioService.getUsuarioById(idUsuario);
            if ( user != null){
                Photo photo = user.getPhoto();
                String str = body.replace("imagen=", ""); 
                str = URLDecoder.decode(str, "UTF-8");
                System.out.println(str);
                photo.setProfile(str);
                fotoService.saveFoto(photo);
            } 
            response.sendRedirect(request.getContextPath() + "/user/profile");
            return "userProfile";             
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            model.addAttribute("mensaje", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/cambiarPortada")
    public String cambiarPortada(Model model, @RequestBody String body, HttpServletRequest request, HttpServletResponse response, BindingResult result) {
        if (result.hasErrors()) { 
            model.addAttribute("mensaje", result.getAllErrors().toString());
            return "error";
        }  
        try {   
            Long idUsuario = (Long) request.getSession().getAttribute("userId");
            User user = usuarioService.getUsuarioById(idUsuario);
            if ( user != null){
                Photo photo = user.getPhoto();
                String str = body.replace("portada=", ""); 
                str = URLDecoder.decode(str, "UTF-8");
                System.out.println(str);
                photo.setFront(str);
                fotoService.saveFoto(photo);
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
            System.out.println("Buscando usuario");
            User user = usuarioService.getUsuarioByCorreo(loginDto.getCorreo().toString());
            System.out.println("Encontrado");
            if (user != null){  
                System.out.println("Mail correcto, verificando contraseña");
                if (passwordEncoder.matches(loginDto.getContraseña(), user.getPassword())){
                    //Coinciden entonces:
                    System.out.println("AUTENTICADO: Dando de baja la cuenta...");
                   
                    user.setActive(false);
                    usuarioService.saveUsuario(user);
                    
                    /* Como en el logout -> */ 
                    request.getSession().removeAttribute("usuario"); 
                    request.getSession().removeAttribute("autenticado"); 
                    response.sendRedirect(request.getContextPath() + "/");
                    return "welcome"; 
                }else{
                    System.out.println("ERROR: Contraseña incorrecta");
                    model.addAttribute("mensaje", "Contraseña incorrecta");
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
