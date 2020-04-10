package com.rpolnx.travel.domain.repository;

import com.rpolnx.travel.domain.entity.Location;
import com.rpolnx.travel.domain.entity.Travel;
import org.springframework.data.repository.CrudRepository;

public interface TravelRepository extends CrudRepository<Travel, Integer> {
}
