package com.unam.poo.services;
import java.util.List;

import com.unam.poo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unam.poo.repository.PublicationRepository;
import com.unam.poo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public User getUserByMail(String mail){
        List<User> users = userRepository.findAll();
        User aux = new User();
        aux.setId(-1); 
        for (int i = 0; i < users.size(); i++) {
            if (mail.equals(users.get(i).getMail())){
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
    public void agregarFavorites(Long idPublicacion, Long id) {
        User user = userRepository.findById(id).get();
        user.getFavorites().add(publicationRepository.findById(idPublicacion).get());
        userRepository.save(user);
    }

    @Override
    public void quitarFavorites(Long idPublicacion, Long id) {
        User user = userRepository.findById(id).get();
        user.getFavorites().remove(publicationRepository.findById(idPublicacion).get());
        userRepository.save(user);
    }

}

