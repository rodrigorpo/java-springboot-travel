package com.rpolnx.travel.domain.repository;

import com.rpolnx.travel.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();
}
