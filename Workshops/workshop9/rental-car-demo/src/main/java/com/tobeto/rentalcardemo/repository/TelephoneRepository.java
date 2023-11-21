package com.tobeto.rentalcardemo.repository;

import com.tobeto.rentalcardemo.entity.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository  extends JpaRepository<Telephone, Integer> {
}
