package com.siva.prodapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.siva.prodapp.dto.*;

@Repository
public interface UsedCarDao extends MongoRepository<Cars, String> {

    // Custom query method to retrieve all cars by company name
    List<Cars> findByCompanyName(String companyName);

    // Custom query method to retrieve all cars by fuel type
    List<Cars> findByFuelType(String fuelType);

}
