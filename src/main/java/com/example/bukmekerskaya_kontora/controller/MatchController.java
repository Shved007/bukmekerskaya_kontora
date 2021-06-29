package com.example.bukmekerskaya_kontora.controller;

import com.example.bukmekerskaya_kontora.dto.MatchDto;
import com.example.bukmekerskaya_kontora.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody MatchDto matchDto){
        matchService.create(matchDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<MatchDto> matchDtoList = matchService.findAll();
        return new ResponseEntity<>(matchDtoList,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{matchId}")
    public ResponseEntity<?> deleteById(@PathVariable Long matchId){
        matchService.deleteById(matchId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
