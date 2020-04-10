package com.rpolnx.travel.domain.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "locations")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Location extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @With
    private Integer id;
    private String name;
    private String imageUrl;
    @ManyToMany
    @JoinTable(
            name = "travels",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    public Location(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Location(Integer id) {
        this.id = id;
    }
}
