package com.example.bukmekerskaya_kontora.dto;


import com.example.bukmekerskaya_kontora.entity.Team;
import com.example.bukmekerskaya_kontora.enums.MatchResult;
import com.example.bukmekerskaya_kontora.enums.MatchStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class MatchDto {

    private Long id;

    @NotEmpty
    @JsonProperty("match_date")
    private Date matchDate;

    @NotNull
    private Team homeTeam;

    @NotNull
    private Team awayTeam;

    @NotNull
    private MatchStatus matchStatus;


    @JsonProperty("home_team_score")
    private int homeTeamScore;

    @JsonProperty("away_team_score")
    private int awayTeamScore;

    @JsonProperty("match_result")
    private MatchResult matchResult;
}
