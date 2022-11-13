package com.usermanagement.service;

import com.usermanagement.entity.User;
import com.usermanagement.model.dto.UserDTO;
import com.usermanagement.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com", "0987654321", "avatar.img", "123"));
        users.add(new User(2, "Bùi Như Lạc", "laclac@gmail.com", "0123456789", "avatar1.img", "123"));
        users.add(new User(3, "Phan Thị Lỏng Lẻo", "longleo@gmail.com", "0987564664", "avatar3.img", "123"));
        users.add(new User(4, "Bành Thị Tèo", "teo@gmail.com", "0874845455", "avatar9.img", "123"));
    }

    @Override
    public List<UserDTO> getListUser() {
        ArrayList<UserDTO> result = new ArrayList<UserDTO>();

        // Convert users -> result
        for (User user : users) {
            result.add(UserMapper.toUserDTO(user));
        }
        return result;
    }

    @Override
    public UserDTO getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return UserMapper.toUserDTO(user);
            }
        }
        return null;
    }

    @Override
    public List<UserDTO> searchUser(String keyword) {
        List<UserDTO> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(keyword)) {
                result.add(UserMapper.toUserDTO(user));
            }
        }
        return result;
    }
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
=======
>>>>>>> 0513185 (deldete user)
>>>>>>> Stashed changes

    @Override
    public UserDTO createUser(CreateUserReq req) {
        for (User user : users) {
            if (user.getEmail().equals(req.getEmail())) {
                throw new DuplicateRecordException("Email already exists in the system");
            }
        }
        User user = new User();
        user.setId(users.size() + 1);
        user.setName(req.getName());
        user.setPhone(req.getPhone());
        user.setEmail(req.getEmail());
        user.setPassword(BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12)));
        users.add(user);
        return UserMapper.toUserDTO(user);
    }

    @Override
    public UserDTO updateUser(UpdateUserReq req, int id) {
        for (User user : users) {
            if (user.getId() == id) {
                if (!user.getEmail().equals(req.getEmail())) {
                    // Check new email exist
                    for (User userWithEmailExist : users) {
                        if (userWithEmailExist.getEmail().equals(req.getEmail())) {
                            throw new DuplicateRecordException("New email already exists in the system");
                        }
                    }
                    user.setEmail(req.getEmail());
                }
                user.setName(req.getName());
                user.setPhone(req.getPhone());
                user.setAvatar(req.getAvatar());
                user.setPassword(BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12)));
                return UserMapper.toUserDTO(user);
            }
        }
        throw new NotFoundException("No user found");
    }
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
=======
>>>>>>> Stashed changes

    @Override
    public boolean deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }

        throw new NotFoundException("No user found");
    }
>>>>>>> Stashed changes
<<<<<<< Updated upstream
=======
>>>>>>> 0513185 (deldete user)
>>>>>>> Stashed changes
}
