package com.rpolnx.travel.service;

import com.rpolnx.travel.domain.dto.LocationDTO;

import java.util.List;

public interface LocationService {
    List<LocationDTO> getAll();

    LocationDTO get(Integer id);

    LocationDTO create(LocationDTO location);

    void update(Integer id, LocationDTO location);

    void delete(Integer id);
}
