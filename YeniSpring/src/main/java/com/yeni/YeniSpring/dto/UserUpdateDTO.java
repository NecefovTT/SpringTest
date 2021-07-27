package com.yeni.YeniSpring.dto;


import com.yeni.YeniSpring.model.Address;
import lombok.Data;

import java.util.List;

@Data
public class UserUpdateDTO {

    private String firstName;

    private String lastName;

    private List<Address> addresses;
}
