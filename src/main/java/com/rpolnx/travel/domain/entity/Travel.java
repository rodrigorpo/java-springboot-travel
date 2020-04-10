package com.rpolnx.travel.domain.entity;

import lombok.*;

import javax.persistence.*;
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
    private Double price;

    public Travel(LocalDateTime scheduledTo, User user, Location location) {
        this.scheduledTo = scheduledTo;
        this.user = user;
        this.location = location;
    }

    @ManyToOne
    private User user;

    @ManyToOne
    private Location location;
}
