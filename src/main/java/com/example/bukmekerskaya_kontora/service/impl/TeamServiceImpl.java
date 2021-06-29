package com.example.bukmekerskaya_kontora.service.impl;

import com.example.bukmekerskaya_kontora.dto.TeamDto;
import com.example.bukmekerskaya_kontora.entity.Team;
import com.example.bukmekerskaya_kontora.exception.BadRequestException;
import com.example.bukmekerskaya_kontora.exception.ResourceNotFoundException;
import com.example.bukmekerskaya_kontora.repository.TeamRepository;
import com.example.bukmekerskaya_kontora.service.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void create(TeamDto teamDto) {
        Team team = modelMapper.map(teamDto, Team.class);
        teamRepository.save(team);
    }

    @Override
    public List<TeamDto> findAll() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(t -> modelMapper.map(t, TeamDto.class)).collect(Collectors.toList());
    }

    @Override
    public TeamDto findById(Long id) {
        Team team = teamRepository.getById(id);
        return modelMapper.map(team, TeamDto.class);
    }

    @Override
    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public void update(Long teamId, TeamDto teamDto) {
        if (teamDto.getId() == null) {
            throw new BadRequestException("Client id must present on update");
        }

        Team team = getTeamById(teamId);

        team.setName(teamDto.getName());
        teamRepository.save(team);
    }

    private Team getTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found by id [ " + id + " ]")
        );
    }
}
