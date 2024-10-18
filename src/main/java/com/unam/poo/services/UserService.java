package com.unam.poo.services;
import com.unam.poo.models.User;

import java.util.List;


public interface UserService {
    List<User> findAll();
    void deleteUserById(Long id);
    User getUserById(Long id);
    User saveUser(User user);
    User getUserByMail(String mail);

    void agregarFavorites(Long idPublicacion,Long id);
    void quitarFavorites(Long idPublicacion,Long id);
}
