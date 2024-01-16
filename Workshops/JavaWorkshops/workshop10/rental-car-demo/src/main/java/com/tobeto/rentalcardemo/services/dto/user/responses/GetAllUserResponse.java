package com.tobeto.rentalcardemo.services.dto.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {

    private int id;
    private String email;
    private String password;
}