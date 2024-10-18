package com.unam.poo.services;
import com.unam.poo.models.User;

import java.util.List;


public interface UsuarioService {
    List<User> findAll();
    void deleteUsuarioById(Long id);
    User getUsuarioById(Long id);
    User saveUsuario(User user);
    User getUsuarioByCorreo(String correo);

    void agregarFavoritos(Long idPublicacion,Long id);
    void quitarFavoritos(Long idPublicacion,Long id);
}
