package com.usermanagement.service;

import com.usermanagement.model.dto.UserDTO;
import com.usermanagement.model.request.CreateUserReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDTO> getListUser();
    public UserDTO getUserById(int id);
    public List<UserDTO> searchUser(String keyword);
    public UserDTO createUser(CreateUserReq req);


}
