package com.rpolnx.travel.service.impl;

import com.rpolnx.travel.common.exceptions.NotFoundException;
import com.rpolnx.travel.domain.dto.UserDTO;
import com.rpolnx.travel.domain.entity.User;
import com.rpolnx.travel.domain.repository.UserRepository;
import com.rpolnx.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDTO> getAll() {
        return repository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO get(Integer id) {
        return repository.findById(id)
                .map(UserDTO::new)
                .orElseThrow(() -> new NotFoundException("UserDTO not found"));
    }

    @Override
    public User getInstance(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("UserDTO not found"));
    }

    @Override
    public User getOrCreateEntity(UserDTO userDTO) {
        if (userDTO.isNewInstance()) {
            return persistEntity(userDTO);
        }

        return repository.findById(userDTO.getId())
                .orElseThrow(() -> new NotFoundException("UserDTO not found"));
    }

    @Override
    public UserDTO create(UserDTO dto) {
        User created = persistEntity(dto);

        return new UserDTO(created.getId());
    }

    @Override
    @Transactional
    public void update(Integer id, UserDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        user.setName(dto.getName());
        user.setName(dto.getCpf());
    }

    @Override
    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception ignored) {
        }
    }

    private User persistEntity(UserDTO dto) {
        User user = new User(dto.getName(), dto.getCpf());
        return repository.save(user);
    }
}
