package com.rpolnx.travel.domain.repository;

import com.rpolnx.travel.domain.entity.Travel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Integer> {
    @Override
    List<Travel> findAll();
}
