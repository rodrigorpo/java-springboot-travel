package com.rpolnx.travel.service;

import com.rpolnx.travel.domain.dto.TravelDTO;

import java.util.List;

public interface TravelService {
    List<TravelDTO> getAll();

    TravelDTO get(Integer id);

    TravelDTO create(TravelDTO travelDTO);

    void update(Integer id, TravelDTO travelDTO);

    void delete(Integer id);
}
