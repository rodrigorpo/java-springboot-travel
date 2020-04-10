package com.rpolnx.travel.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @With
    private Integer id;
    private String name;
    private String cpf;

    @ManyToMany
    @JoinTable(
            name = "travels",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Set<Location> locations;

    public User(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public User(Integer id) {
        this.id = id;
    }
}
