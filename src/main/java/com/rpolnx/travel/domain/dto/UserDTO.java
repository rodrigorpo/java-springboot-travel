package com.rpolnx.travel.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rpolnx.travel.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {
    private Integer id;
    @NotNull @NotBlank @JsonInclude(Include.NON_NULL)
    private String name;
    @NotNull @NotBlank @JsonInclude(Include.NON_NULL)
    private String cpf;

    public UserDTO(Integer id) {
        this.id = id;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
    }
}
