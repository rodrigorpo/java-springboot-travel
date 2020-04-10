package com.rpolnx.travel.service.impl;

import com.rpolnx.travel.common.exceptions.NotFoundException;
import com.rpolnx.travel.domain.dto.LocationDTO;
import com.rpolnx.travel.domain.entity.Location;
import com.rpolnx.travel.domain.repository.LocationRepository;
import com.rpolnx.travel.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository repository;

    @Autowired
    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LocationDTO> getAll() {
        return repository.findAll().stream()
                .map(LocationDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO get(Integer id) {
        return repository.findById(id)
                .map(LocationDTO::new)
                .orElseThrow(() -> new NotFoundException("LocationDTO Not Found"));
    }

    @Override
    public Location getInstance(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("LocationDTO Not Found"));
    }

    @Override
    public Location getOrCreateEntity(LocationDTO dto) {
        if (dto.isNewInstance()) {
            return persistEntity(dto);
        }

        return repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("UserDTO not found"));
    }

    @Override
    public LocationDTO create(LocationDTO dto) {
        Location created = persistEntity(dto);

        return new LocationDTO(created.getId());
    }

    @Override
    @Transactional
    public void update(Integer id, LocationDTO dto) {
        Location location = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        location.setName(dto.getName());
        location.setImageUrl(dto.getImageUrl());
    }

    @Override
    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception ignored) {
        }
    }

    private Location persistEntity(LocationDTO dto) {
        Location location = new Location(dto.getName(), dto.getImageUrl());
        return repository.save(location);
    }
}
