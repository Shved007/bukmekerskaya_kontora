package com.example.bukmekerskaya_kontora.service.impl;

import com.example.bukmekerskaya_kontora.dto.MatchDto;
import com.example.bukmekerskaya_kontora.entity.Match;
import com.example.bukmekerskaya_kontora.enums.MatchStatus;
import com.example.bukmekerskaya_kontora.exception.ResourceNotFoundException;
import com.example.bukmekerskaya_kontora.repository.MatchRepository;
import com.example.bukmekerskaya_kontora.service.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final ModelMapper modelMapper;

    public MatchServiceImpl(MatchRepository matchRepository, ModelMapper modelMapper) {
        this.matchRepository = matchRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void create(MatchDto matchDto) {
        Match match = modelMapper.map(matchDto, Match.class);
        matchRepository.save(match);
    }

    @Override
    public List<MatchDto> findAll() {
        List<Match> matches = matchRepository.findAll();
        return matches.stream().map(m -> modelMapper.map(m, MatchDto.class)).collect(Collectors.toList());
    }

    @Override
    public MatchDto findById(Long id) {
        Match match = matchRepository.getById(id);
        return modelMapper.map(match,MatchDto.class);
    }

    @Override
    public void deleteById(long id) {
        matchRepository.deleteById(id);
    }

    private Match getMatchById(Long matchId){
    return matchRepository.findById(matchId).orElseThrow( () -> new ResourceNotFoundException("Resource not found by id [ " + matchId + " ]"));
    }
}
