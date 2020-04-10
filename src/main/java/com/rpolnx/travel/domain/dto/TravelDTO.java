package com.rpolnx.travel.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TravelDTO {
    private Integer id;
    private LocalDateTime scheduledTo;
    private Double price;
    private UserDTO user;
    private LocationDTO location;
}
