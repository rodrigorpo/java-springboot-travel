package com.rpolnx.travel.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rpolnx.travel.domain.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LocationDTO {
    private Integer id;
    @NotNull @NotBlank @JsonInclude(Include.NON_NULL)
    private String name;
    @JsonInclude(Include.NON_NULL)
    private String imageUrl;

    public LocationDTO(Integer id) {
        this.id = id;
    }

    public LocationDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.imageUrl = location.getImageUrl();
    }
}
