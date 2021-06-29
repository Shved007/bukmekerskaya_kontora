package com.example.bukmekerskaya_kontora.service;

import com.example.bukmekerskaya_kontora.dto.MatchDto;
import java.util.List;
public interface MatchService {

    void create (MatchDto matchDto);

    List<MatchDto> findAll();

    MatchDto findById(Long id);

    void deleteById(long id);

}
