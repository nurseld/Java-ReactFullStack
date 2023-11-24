package com.tobeto.rentalcardemo.services.dto.telephone.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTelephoneResponse {

    private String description;

    private String phoneNumber;
}
