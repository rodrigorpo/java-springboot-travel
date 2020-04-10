package com.rpolnx.travel.domain.repository;

import com.rpolnx.travel.domain.entity.Location;
import com.rpolnx.travel.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Integer> {
    @Override
    List<Location> findAll();
}
