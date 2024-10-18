package com.unam.poo.controllers.auth;
import com.unam.poo.controllers.PanelUsrController;
import com.unam.poo.dto.LoginDto;
import com.unam.poo.models.User;
import com.unam.poo.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping; 
 
@Controller
public class LoginController { 

    @Autowired
    UserService userService; 
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PanelUsrController panelUsrController;

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException { 
        request.getSession().removeAttribute("user"); 
        request.getSession().removeAttribute("autenticado"); 
        response.sendRedirect(request.getContextPath() + "/");
        return "welcome";
    }

    @GetMapping("/login")
    public String loginload() {
        return "authLogin";
    } 

//    public String loginredirect () {
//        Model m
//        return panelUsrController.panelUsr();}

    @PostMapping("/login")
    public String login(Model model, @Validated @ModelAttribute("LoginDto") LoginDto loginDto, HttpServletRequest request, HttpServletResponse response, BindingResult result) {
        if (result.hasErrors()) { 
          return "Error";
        }  
        try { 
            User user = userService.getUserByMail(loginDto.getMail().toString());
            if (user != null){  
                if (user.getActive()){
                    if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
                        //Coinciden entonces:
                        System.out.println("AUTENTICADO: Redireccionando...");
                       
                        
                        request.getSession().setAttribute("userId", user.getId()); 
                        request.getSession().setAttribute("autenticado", "true"); 
                        
                        /*C1: Ejemplo de como mapear la variable de Session Storage para su uso
    
                        HttpSession httpSession = request.getSession();
                        request.getSession().setAttribute("user", user); 
    
                        System.out.println("HTTP SESSION USER (Objeto): " + httpSession.getAttribute("user"));
    
                        System.out.println("Para mapear como un objeto User de nuestro modelo:");
                        ObjectMapper mapper = new ObjectMapper();
    
                        System.out.println("Se transforma el objeto generico de la session storage en Json");
                        String userJson = mapper.writeValueAsString(httpSession.getAttribute("user"));
                        request.getSession().removeAttribute("user"); 
    
                        System.out.println("Se transforma el Json en un objeto User de nuestro modelo");
                        User userMapped = mapper.readValue(userJson, User.class);
                        
                        System.out.println("Se realiza el mapping con exito, los datos son: ");
                        System.out.println("ID: " + userMapped.getId());
                        System.out.println("Name: " + userMapped.getName());
                        System.out.println("Lastname: " + userMapped.getLastName());
                        System.out.println("DNI: " + userMapped.getDni());
                        System.out.println("Mail: " + userMapped.getMail());
    
                        System.out.println("Mediante controladores podemos usar el dato de ID de este user para obtener publicaciones, etc.");
                        
                        Todo lo de arriba hasta el comentario C1 es opcional y se puede eliminar o comentar a gusto */
                        
                        /* cambiar para redireccionar a panel de user -> */ 
                        
                        response.sendRedirect(request.getContextPath() + "/");
                        return "welcome";
                        /* Alternativa: response.sendRedirect() */
                    }else{
                        System.out.println("ERROR: Password incorrecta");
                        model.addAttribute("mensaje", "Password incorrecta");
                        return "error";
                        //return "authLogin";
                    }
                }else{
                    System.out.println("ERROR: User inactive");
                    model.addAttribute("mensaje", "User inactive");
                    return "error";
                }
            }else{
                System.out.println("ERROR: User no registrado");
                model.addAttribute("mensaje", "User no registrado");
                return "error";
            } 
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            model.addAttribute("mensaje", e.getMessage());
            return "error";
        }


    }
}