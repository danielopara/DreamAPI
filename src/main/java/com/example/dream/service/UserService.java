package com.example.dream.service;

import com.example.dream.model.Users;
import com.example.dream.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements UserServiceImpl {
    @Autowired
    private UserRepo userRepo;
//    @Autowired
//    private Users users;
    @Override
    public List<Users> listUsers() {
        return userRepo.findAll();
    }

    @Override
    public Users addUser(Users user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<Users> getById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public Users updateUser(Long id, Users user) {
        Optional<Users> byId = userRepo.findById(id);
        if(byId.isEmpty()){
            throw  new RuntimeException("User does not exist");
        }
        Users foundUser = byId.get();
        foundUser.setName(user.getName());
        foundUser.setDescription(user.getDescription());
        return userRepo.save(foundUser);
    }
}
