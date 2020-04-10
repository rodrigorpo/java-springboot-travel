package com.rpolnx.travel.service.impl;

import com.rpolnx.travel.common.exceptions.NotFoundException;
import com.rpolnx.travel.domain.dto.LocationDTO;
import com.rpolnx.travel.domain.dto.TravelDTO;
import com.rpolnx.travel.domain.dto.UserDTO;
import com.rpolnx.travel.domain.entity.Location;
import com.rpolnx.travel.domain.entity.Travel;
import com.rpolnx.travel.domain.entity.User;
import com.rpolnx.travel.domain.repository.TravelRepository;
import com.rpolnx.travel.service.LocationService;
import com.rpolnx.travel.service.TravelService;
import com.rpolnx.travel.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelServiceImpl implements TravelService {
    private final TravelRepository travelRepository;
    private final UserService userService;
    private final LocationService locationService;

    public TravelServiceImpl(TravelRepository travelRepository, UserService userService, LocationService locationService) {
        this.travelRepository = travelRepository;
        this.userService = userService;
        this.locationService = locationService;
    }

    @Override
    public List<TravelDTO> getAll() {
        return travelRepository.findAll().stream()
                .map(this::buildTravelDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TravelDTO get(Integer id) {
        return travelRepository.findById(id)
                .map(this::buildTravelDTO)
                .orElseThrow(() -> new NotFoundException("Travel Not Found"));
    }

    @Override
    public TravelDTO create(TravelDTO dto) {
        User user = userService.getOrCreateEntity(dto.getUser());
        Location location = locationService.getOrCreateEntity(dto.getLocation());

        Travel created = this.persistInstance(dto, user, location);

        return new TravelDTO(created.getId());
    }

    @Override
    public void update(Integer id, TravelDTO dto) {
        User user = userService.getInstance(dto.getUser().getId());
        Location location = locationService.getInstance(dto.getLocation().getId());

        Travel travel = new Travel(dto.getScheduledTo(), dto.getPrice(), user, location).withId(id);

        travelRepository.save(travel);
    }

    @Override
    public void delete(Integer id) {
        try {
            travelRepository.deleteById(id);
        } catch (Exception ignored) { }
    }

    private TravelDTO buildTravelDTO(Travel travel) {
        UserDTO user = new UserDTO(travel.getUser());
        LocationDTO location = new LocationDTO(travel.getLocation());

        return new TravelDTO(travel, user, location);
    }

    private Travel persistInstance(TravelDTO dto, User user, Location location) {
        Travel travel = new Travel(dto.getScheduledTo(), dto.getPrice(), user, location);
        return travelRepository.save(travel);
    }
}
