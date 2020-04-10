package com.rpolnx.travel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rpolnx.travel.domain.entity.Travel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TravelDTO {
    private Integer id;
    @NotNull @NotBlank @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime scheduledTo;
    @NotNull @NotBlank @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal price;
    @NotNull @NotBlank @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDTO user;
    @NotNull @NotBlank @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocationDTO location;

    public TravelDTO(Travel travel, UserDTO user, LocationDTO location) {
        this.id = travel.getId();
        this.scheduledTo = travel.getScheduledTo();
        this.price = travel.getPrice();
        this.user = user;
        this.location = location;
    }

    public TravelDTO(Integer id) {
        this.id = id;
    }
}
