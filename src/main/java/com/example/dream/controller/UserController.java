package com.example.dream.controller;

import com.example.dream.model.Users;
import com.example.dream.service.UserService;
import com.example.dream.service.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dream")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("user")
    public ResponseEntity<List<Users>> listUsers(){
        return new ResponseEntity<List<Users>>(userService.listUsers(), HttpStatus.OK);
    }
    @PostMapping("addUser")
    public ResponseEntity<Users> addUser(@RequestBody Users user){
        return new ResponseEntity<Users>(userService.addUser(user), HttpStatus.OK);
    }

    @PutMapping("updateUser/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user){
        return new ResponseEntity<Users>(userService.updateUser(id, user), HttpStatus.OK);
    }
}
