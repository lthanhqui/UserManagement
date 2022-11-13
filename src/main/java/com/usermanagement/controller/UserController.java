package com.usermanagement.controller;

import com.usermanagement.model.dto.UserDTO;
import com.usermanagement.model.request.CreateUserReq;
import com.usermanagement.model.request.UpdateUserReq;
import com.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<UserDTO> result = userService.getListUser();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserDTO result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam ( required = false, defaultValue = "")  String name){
        List<UserDTO> result = userService.searchUser(name);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserReq req){
        UserDTO result = userService.createUser(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserReq req, @PathVariable int id) {
        UserDTO result = userService.updateUser(req, id);
        return ResponseEntity.ok(result);
    }
}
