package com.tobeto.rentalcardemo.services.abstracts;

import com.tobeto.rentalcardemo.entity.Telephone;
import com.tobeto.rentalcardemo.services.dto.telephone.requests.AddTelephoneRequest;
import com.tobeto.rentalcardemo.services.dto.telephone.requests.UpdateTelephoneRequest;
import com.tobeto.rentalcardemo.services.dto.telephone.responses.AddTelephoneResponse;
import com.tobeto.rentalcardemo.services.dto.telephone.responses.GetAllTelephoneResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TelephoneService {

    AddTelephoneResponse add(AddTelephoneRequest request);
    List<GetAllTelephoneResponse> getAll();
    GetAllTelephoneResponse getById(Integer telephoneId);
    void delete(Integer telephoneId);
    void update(UpdateTelephoneRequest request);
    List<Telephone> getDescription(String description);
    List<GetAllTelephoneResponse> getDetailPhone(String phoneNumber);
}
