package com.rpolnx.travel.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "travels")
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Travel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @With
    private Integer id;
    private LocalDateTime scheduledTo;
    private BigDecimal price;

    public Travel(LocalDateTime scheduledTo, User user, Location location) {
        this.scheduledTo = scheduledTo;
        this.user = user;
        this.location = location;
    }

    public Travel(LocalDateTime scheduledTo, BigDecimal price, User user, Location location) {
        this.scheduledTo = scheduledTo;
        this.price = price;
        this.user = user;
        this.location = location;
    }

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private Location location;
}
