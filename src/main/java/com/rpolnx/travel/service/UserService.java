package com.rpolnx.travel.service;

import com.rpolnx.travel.domain.dto.UserDTO;
import com.rpolnx.travel.domain.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();

    UserDTO get(Integer id);

    User getInstance(Integer id);

    User getOrCreateEntity(UserDTO userDTO);

    UserDTO create(UserDTO user);

    void update(Integer id, UserDTO user);

    void delete(Integer id);
}
