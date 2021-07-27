package com.yeni.YeniSpring.service.impl;

import com.yeni.YeniSpring.dto.UserCreateDTO;
import com.yeni.YeniSpring.dto.UserDTO;
import com.yeni.YeniSpring.dto.UserUpdateDTO;
import com.yeni.YeniSpring.exception.NotFoundException;
import com.yeni.YeniSpring.model.User;
import com.yeni.YeniSpring.repository.UserRespository;
import com.yeni.YeniSpring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRespository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserById(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserDTO.of(user);
    }

    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository
                .save(new User(userCreateDTO.getFirstName(), userCreateDTO.getLastName(), userCreateDTO.getAddresses()));
        System.out.println(userCreateDTO + "--------");
        return UserDTO.of(user);
    }


//    @Override
//    public UserDTO createUser(UserCreateDTO userCreateDTO) {
//        User userForSave = new User(userCreateDTO.getFirstName(), userCreateDTO.getLastName(), userCreateDTO.getAddresses());
//        userForSave.getAddresses().forEach(u -> u.setUser(userForSave));
//        final User user = userRepository
//                .save(userForSave);
//        System.out.println(user.getAddresses());
//        return UserDTO.of(user);
//    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllUser() {
        List<UserDTO> list = userRepository.findAll()
                .stream().map(UserDTO::of).collect(Collectors.toList());
        return list;
    }

    @Override
    public UserDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Exception"));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        user.setAddresses(user.getAddresses());

        final User updateUser = userRepository.save(user);
        return UserDTO.of(updateUser);
    }

    @Override
    public UserDTO deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Exception"));

        userRepository.deleteById(user.getUserId());
        return UserDTO.of(user);
    }

    @Override
    public List<UserDTO> slice(Pageable pageable) {
        return userRepository.findAll(pageable).
                stream().map(UserDTO::of).collect(Collectors.toList());
    }
}
