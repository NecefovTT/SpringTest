package com.yeni.YeniSpring.controller;

import com.yeni.YeniSpring.dto.UserCreateDTO;
import com.yeni.YeniSpring.dto.UserDTO;
import com.yeni.YeniSpring.dto.UserUpdateDTO;
import com.yeni.YeniSpring.service.UserService;
import com.yeni.YeniSpring.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserDTO> getUserId(@PathVariable Long id) {
        final UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("v1/users")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        final List<UserDTO> list = userService.getAllUser();
        return ResponseEntity.ok(list);
    }

    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User created!"));
    }


    @PutMapping("v1/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id,
                                        @RequestBody UserUpdateDTO userUpdateDTO) {
        final UserDTO userDTO = userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        final UserDTO userDTO = userService.deleteUser(id);
        return ResponseEntity.ok(userDTO.getFirstName() + " " + userDTO.getLastName() + " was deleted!");
    }

    @GetMapping("v1/users/slice")
    public ResponseEntity<List<UserDTO>> userSlice(Pageable pageable) {
        final List<UserDTO> list = userService.slice(pageable);
        return ResponseEntity.ok(list);
    }

}
