package com.tobeto.rentalcardemo.services.dto.telephone.requests;

import lombok.Data;

@Data
public class UpdateTelephoneRequest {

    private  Integer id;

    private String description;

    private String phoneNumber;
}
