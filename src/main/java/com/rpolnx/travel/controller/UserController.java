package com.rpolnx.travel.controller;

import com.rpolnx.travel.domain.dto.UserDTO;
import com.rpolnx.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public UserDTO get(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @PostMapping
    public UserDTO create(@RequestBody @Valid UserDTO user) {
        return service.create(user);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid UserDTO user) {
        service.update(id, user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
