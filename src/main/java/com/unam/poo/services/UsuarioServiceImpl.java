package com.unam.poo.services;
import java.util.List;

import com.unam.poo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unam.poo.repository.PublicationRepository;
import com.unam.poo.repository.UserRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUsuarioById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUsuarioById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveUsuario(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public User getUsuarioByCorreo(String correo){
        List<User> users = userRepository.findAll();
        User aux = new User();
        aux.setId(-1); 
        for (int i = 0; i < users.size(); i++) {
            if (correo.equals(users.get(i).getMail())){
                System.out.println("Encontrado: " + users.get(i).getMail());
                aux = users.get(i);
            }
        }
        if (aux.getId() > 0){
            return aux;
        }
        return null;
        
    }

    @Override
    public void agregarFavoritos(Long idPublicacion, Long id) {
        User user = userRepository.findById(id).get();
        user.getFavorites().add(publicationRepository.findById(idPublicacion).get());
        userRepository.save(user);
    }

    @Override
    public void quitarFavoritos(Long idPublicacion, Long id) {
        User user = userRepository.findById(id).get();
        user.getFavorites().remove(publicationRepository.findById(idPublicacion).get());
        userRepository.save(user);
    }

}

