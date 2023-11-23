package com.tobeto.rentalcardemo.services.dto.telephone.requests;

import lombok.Data;

@Data
public class AddTelephoneRequest {

    private String description;

    private String phoneNumber;
}
