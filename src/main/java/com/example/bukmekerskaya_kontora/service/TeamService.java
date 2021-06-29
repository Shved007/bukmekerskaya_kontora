package com.example.bukmekerskaya_kontora.service;

import com.example.bukmekerskaya_kontora.dto.TeamDto;
import java.util.List;
public interface TeamService {

    void create (TeamDto teamDto);

    List<TeamDto> findAll();

    TeamDto findById(Long id);

    void deleteById(Long id);

    void update(Long teamId, TeamDto teamDto);

}
