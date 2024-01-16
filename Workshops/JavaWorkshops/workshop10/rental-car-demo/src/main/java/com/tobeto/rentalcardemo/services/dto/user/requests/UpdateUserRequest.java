package com.tobeto.rentalcardemo.services.dto.user.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private Integer id;
    private String firsName;
    private String lastName;
    private String email;
    private String password;
    private String role;

}