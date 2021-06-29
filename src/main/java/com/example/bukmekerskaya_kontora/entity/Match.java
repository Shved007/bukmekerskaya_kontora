package com.example.bukmekerskaya_kontora.entity;

import com.example.bukmekerskaya_kontora.enums.MatchResult;
import com.example.bukmekerskaya_kontora.enums.MatchStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "match_date")
    private Date matchDate;

    @OneToOne
    @JoinColumn(name = "home_team_id", nullable = false)
    private Team homeTeam;

    @OneToOne
    @JoinColumn(name = "away_team_id", nullable = false)
    private Team awayTeam;

    @Column(name = "home_team_score")
    private int homeTeamScore;

    @Column(name = "away_team_score")
    private int awayTeamScore;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MatchStatus matchStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private MatchResult  matchResult;
}
