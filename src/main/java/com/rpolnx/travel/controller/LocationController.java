package com.rpolnx.travel.controller;

import com.rpolnx.travel.domain.dto.LocationDTO;
import com.rpolnx.travel.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationController {
    private final LocationService service;

    @Autowired
    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping
    public List<LocationDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public LocationDTO get(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @PostMapping
    public LocationDTO create(@RequestBody @Valid LocationDTO location) {
        return service.create(location);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid LocationDTO location) {
        service.update(id, location);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
