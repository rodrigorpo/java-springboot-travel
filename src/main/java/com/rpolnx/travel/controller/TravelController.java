package com.rpolnx.travel.controller;

import com.rpolnx.travel.domain.dto.TravelDTO;
import com.rpolnx.travel.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TravelDTO create(@RequestBody TravelDTO dto) {
        return travelService.create(dto);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody TravelDTO dto) {
        travelService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        travelService.delete(id);
    }
}
