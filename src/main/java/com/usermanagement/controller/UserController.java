package com.usermanagement.controller;

import com.usermanagement.model.dto.UserDTO;
import com.usermanagement.model.request.CreateUserReq;
import com.usermanagement.model.request.UpdateUserReq;
import com.usermanagement.model.request.UploadFile;
import com.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private static String UPLOAD_DIR = System.getProperty("user.home") + "/upload";
    @Autowired
    public UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        List<UserDTO> result = userService.getListUser();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDTO result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(required = false, defaultValue = "") String name) {
        List<UserDTO> result = userService.searchUser(name);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserReq req) {
        UserDTO result = userService.createUser(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserReq req, @PathVariable int id) {
        UserDTO result = userService.updateUser(req, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Delete success");
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@ModelAttribute("uploadForm") UploadFile form) {
        // Create folder to save file if not exist
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        MultipartFile fileData = form.getFileData();
        String name = fileData.getOriginalFilename();
        if (name != null && name.length() > 0) {
            try {
                // Create file
                File serverFile = new File(UPLOAD_DIR + "/" + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(fileData.getBytes());
                stream.close();
                return ResponseEntity.ok("/file/" + name);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when uploading");
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }


}
