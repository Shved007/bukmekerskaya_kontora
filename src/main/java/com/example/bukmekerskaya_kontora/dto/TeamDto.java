package com.example.bukmekerskaya_kontora.dto;

import com.example.bukmekerskaya_kontora.enums.TeamStatus;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TeamDto {
    private Long id;

    @NotEmpty
    private String name;

}
