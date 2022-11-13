package com.usermanagement.service;

import com.usermanagement.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDTO> getListUser();
    public UserDTO getUserById(int id);
    public List<UserDTO> searchUser(String keyword);
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
    public UserDTO createUser(CreateUserReq req);
    public UserDTO updateUser(UpdateUserReq red, int id);
    public boolean deleteUser(int id);
>>>>>>> Stashed changes
=======
<<<<<<< HEAD
    public UserDTO createUser(CreateUserReq req);
    public UserDTO updateUser(UpdateUserReq red, int id);
=======
<<<<<<< Updated upstream
=======
    public UserDTO createUser(CreateUserReq req);
    public UserDTO updateUser(UpdateUserReq red, int id);
    public boolean deleteUser(int id);
>>>>>>> Stashed changes
>>>>>>> 0513185 (deldete user)
>>>>>>> Stashed changes


}
