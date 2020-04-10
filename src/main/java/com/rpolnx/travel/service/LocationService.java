package com.rpolnx.travel.service;

import com.rpolnx.travel.domain.dto.LocationDTO;
import com.rpolnx.travel.domain.entity.Location;

import java.util.List;

public interface LocationService {
    List<LocationDTO> getAll();

    LocationDTO get(Integer id);

    Location getInstance(Integer id);

    Location getOrCreateEntity(LocationDTO dto);

    LocationDTO create(LocationDTO location);

    void update(Integer id, LocationDTO location);

    void delete(Integer id);
}
