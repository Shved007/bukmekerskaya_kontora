package com.example.bukmekerskaya_kontora.controller;


import com.example.bukmekerskaya_kontora.dto.TeamDto;
import com.example.bukmekerskaya_kontora.entity.Team;
import com.example.bukmekerskaya_kontora.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<?> showAllTeams(){
        List<TeamDto> teamList = teamService.findAll();
        return new ResponseEntity<>(teamList, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> createNewTeam(@RequestBody TeamDto teamDto){
        teamService.create(teamDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{teamId}")
   public ResponseEntity<?> findById(@PathVariable Long teamId){
        TeamDto teamDto = teamService.findById(teamId);
        return new ResponseEntity<>(teamDto,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{teamId}")
    public ResponseEntity<?> deleteById(@PathVariable Long teamId){
        teamService.deleteById(teamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{teamId}")
    public ResponseEntity<?> update(@PathVariable Long teamId,@RequestBody TeamDto teamDto){
        teamService.update(teamId,teamDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
