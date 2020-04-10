package com.rpolnx.travel.domain.repository;

import com.rpolnx.travel.domain.entity.Location;
import com.rpolnx.travel.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
    @Override
    List<Location> findAll();
}
