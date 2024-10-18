package com.unam.poo.controllers;

import com.unam.poo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.unam.poo.services.UserService;

import java.util.List;


@Controller
//esta es como una ruta general de la clase
@RequestMapping("/panel")
public class PanelUsrController {
    @Autowired UserService userService;

    //esta es la ruta especifica de la funcion
    // entonces queda localhost:8080/panel/panelUsr
    @GetMapping("/panelusr")
    public String panelUsr(Model model) {
        //esto es lo mismo que POO1
        List<User> users = userService.findAll();
        //model.addAllAttributes(users);
        //aca agregamos los atributos al modelo que es lo
        //que usamos en el html para mostrar los datos
        model.addAttribute("users", users);
        //retornamos el name del JSP que queremos mostrar
        //cuando se llame a esta funcion por la ruta
        //en este caso la tabla de users que esta en WEB-INF/jsp/table.jsp
        return "table";
    }
}
