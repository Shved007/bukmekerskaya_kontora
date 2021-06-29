package com.example.bukmekerskaya_kontora.repository;

import com.example.bukmekerskaya_kontora.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository  extends JpaRepository<Match,Long> {
}
