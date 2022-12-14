package com.usermanagement.service;

import com.usermanagement.model.dto.UserDTO;
import com.usermanagement.model.request.CreateUserReq;
import com.usermanagement.model.request.UpdateUserReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDTO> getListUser();
    public UserDTO getUserById(int id);
    public List<UserDTO> searchUser(String keyword);
    public UserDTO createUser(CreateUserReq req);
    public UserDTO updateUser(UpdateUserReq red, int id);
    public boolean deleteUser(int id);


}
