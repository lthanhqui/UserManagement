package com.usermanagement.service;

import com.usermanagement.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDTO> getListUser();


}
