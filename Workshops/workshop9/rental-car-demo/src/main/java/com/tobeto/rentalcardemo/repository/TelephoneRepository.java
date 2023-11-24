package com.tobeto.rentalcardemo.repository;

import com.tobeto.rentalcardemo.entity.Telephone;
import com.tobeto.rentalcardemo.services.dto.telephone.responses.GetAllTelephoneResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelephoneRepository  extends JpaRepository<Telephone, Integer> {

    List<Telephone> findByDescription(String description);

    @Query("Select new com.tobeto.rentalcardemo.services.dto.telephone.responses.GetAllTelephoneResponse(t.description,t.phoneNumber) " +
            "FROM Telephone t WHERE t.phoneNumber LIKE '%phoneNumber%' ")
    List<GetAllTelephoneResponse> findDetailPhone(String phoneNumber);
}
