package com.usermanagement.model.mapper;

import com.usermanagement.entity.User;
import com.usermanagement.model.dto.UserDTO;

public class UserMapper {
    /**
     * Convert User to UserDTO
     * @param user
     * @return
     */
    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPhone(user.getPhone());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

}
