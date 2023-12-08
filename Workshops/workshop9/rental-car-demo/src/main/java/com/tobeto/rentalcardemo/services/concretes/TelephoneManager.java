package com.tobeto.rentalcardemo.services.concretes;

import com.tobeto.rentalcardemo.core.utilities.exceptions.BusinessException;
import com.tobeto.rentalcardemo.entity.Telephone;
import com.tobeto.rentalcardemo.repository.CustomerRepository;
import com.tobeto.rentalcardemo.repository.TelephoneRepository;
import com.tobeto.rentalcardemo.services.abstracts.TelephoneService;
import com.tobeto.rentalcardemo.services.dto.telephone.requests.AddTelephoneRequest;
import com.tobeto.rentalcardemo.services.dto.telephone.requests.UpdateTelephoneRequest;
import com.tobeto.rentalcardemo.services.dto.telephone.responses.AddTelephoneResponse;
import com.tobeto.rentalcardemo.services.dto.telephone.responses.GetAllTelephoneResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelephoneManager implements TelephoneService {

   private final TelephoneRepository telephoneRepository;


    public TelephoneManager(TelephoneRepository telephoneRepository, CustomerRepository customerRepository) {
        this.telephoneRepository = telephoneRepository;

    }


    @Override
    public AddTelephoneResponse add(AddTelephoneRequest request) {

        if (telephoneRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new BusinessException("This phone number is already in use.");
        }


        Telephone telephone = new Telephone();

        telephone.setDescription(request.getDescription());
        telephone.setPhoneNumber(request.getPhoneNumber());

        Telephone savedTelephone = telephoneRepository.save(telephone);
        AddTelephoneResponse response = new AddTelephoneResponse();
        response.setId(savedTelephone.getPhoneId());
        return response;
    }

    @Override
    public List<GetAllTelephoneResponse> getAll() {

/*        List<Telephone> telephoneList = telephoneRepository.findAll();

        List<GetAllTelephoneResponse> responses = new ArrayList<>();

        for (Telephone telephone : telephoneList) {

            GetAllTelephoneResponse response = new GetAllTelephoneResponse();

            response.setDescription(telephone.getDescription());
            response.setPhoneNumber(telephone.getPhoneNumber());

            responses.add(response);

        }

        return responses;*/

        return telephoneRepository.findAll()
                .stream()
                .map(telephone -> new GetAllTelephoneResponse(telephone.getDescription(), telephone.getPhoneNumber())).toList();
    }

    @Override
    public GetAllTelephoneResponse getById(Integer telephoneId) {

        Telephone telephoneInDb = telephoneRepository.findById(telephoneId)
                .orElseThrow(()-> new RuntimeException("Telephone does not exist."));

        GetAllTelephoneResponse response = new GetAllTelephoneResponse();

        response.setDescription(telephoneInDb.getDescription());
        response.setPhoneNumber(telephoneInDb.getPhoneNumber());

        return response;
    }

    @Override
    public void delete(Integer telephoneId) {

        telephoneRepository.deleteById(telephoneId);
    }

    @Override
    public void update(UpdateTelephoneRequest request) {

        Telephone telephoneInDb = telephoneRepository.findById(request.getTelephoneId()).orElseThrow(()-> new RuntimeException("Telephone does not exist."));

        telephoneInDb.setDescription(request.getDescription());
        telephoneInDb.setPhoneNumber(request.getPhoneNumber());

        telephoneRepository.save(telephoneInDb);

    }

    @Override
    public List<Telephone> getDescription(String description) {

        return telephoneRepository.findByDescription(description);
    }

    @Override
    public List<GetAllTelephoneResponse> getDetailPhone(String phoneNumber) {

        //return telephoneRepository.findDetailPhone(phoneNumber);
        List<Telephone> telephonesList = telephoneRepository.findAll();
        return telephonesList.stream().filter(telephone -> telephone.getPhoneNumber().contains(phoneNumber))
                .map(telephone -> new GetAllTelephoneResponse(telephone.getDescription(),telephone.getPhoneNumber())).toList();
    }
}
