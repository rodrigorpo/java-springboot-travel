package com.rpolnx.travel.controller;

import com.rpolnx.travel.domain.entity.Travel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("travels/users")
public class TravelController {

    @GetMapping
    public List<Travel> getAll() {
        return null;
    }

    @GetMapping("{userId}")
    public Travel get(@PathVariable("userId") Long userId) {
        return null;
    }

    @PostMapping
    public Travel create(Travel travel) {
        return null;
    }

    @PutMapping("{userId}")
    public Travel update(@PathVariable("userId") Long userId, Travel travel) {
        return null;
    }

    @DeleteMapping("{userId}")
    public void delete(@PathVariable("userId") Long userId) {
    }
}
