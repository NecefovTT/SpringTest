package com.yeni.YeniSpring.dto;

import com.yeni.YeniSpring.model.Address;
import com.yeni.YeniSpring.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {

    @NotNull(message = "{backend.constraints.lastName.NotNull.message}")
    @Size(min = 3, max = 30, message = "{backend.constraints.firstName.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastName.NotNull.message }")
    @Size(min = 3, max = 30, message = "{backend.constraints.lastName.Size.message}")
    private String lastName;

    private List<Address> addresses = new ArrayList<>();
}
