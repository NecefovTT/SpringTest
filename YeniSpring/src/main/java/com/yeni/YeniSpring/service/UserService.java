package com.yeni.YeniSpring.service;

import com.yeni.YeniSpring.dto.UserCreateDTO;
import com.yeni.YeniSpring.dto.UserDTO;
import com.yeni.YeniSpring.dto.UserUpdateDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDTO getUserById(Long id);

    UserDTO createUser(UserCreateDTO userCreateDTO);

    List<UserDTO> getAllUser();

    UserDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

    UserDTO deleteUser(Long id);

    List<UserDTO> slice(Pageable pageable);
}
