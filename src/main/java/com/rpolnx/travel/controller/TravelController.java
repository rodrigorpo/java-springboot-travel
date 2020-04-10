package com.rpolnx.travel.controller;

import com.rpolnx.travel.domain.dto.TravelDTO;
import com.rpolnx.travel.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("travels")
public class TravelController {
    private final TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping
    public List<TravelDTO> getAll() {
        return travelService.getAll();
    }

    @GetMapping("{id}")
    public TravelDTO get(@PathVariable("id") Integer id) {
        return travelService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TravelDTO create(@RequestBody TravelDTO dto) {
        return travelService.create(dto);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Integer id, @RequestBody TravelDTO dto) {
        travelService.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        travelService.delete(id);
    }
}
