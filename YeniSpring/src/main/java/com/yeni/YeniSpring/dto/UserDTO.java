package com.yeni.YeniSpring.dto;

import com.yeni.YeniSpring.model.Address;
import com.yeni.YeniSpring.model.User;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
public final class UserDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private final String firstName;

    private final String lastName;

    private List<Address> addresses;

    private UserDTO(String firstName, String lastName, List<Address> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
    }

    public static UserDTO of(User user) {
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getAddresses());
    }
}
