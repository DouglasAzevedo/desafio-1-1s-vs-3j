package br.com.desafio.codecon.controller;

import br.com.desafio.codecon.domain.response.team.TeamStats;
import br.com.desafio.codecon.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team-insights")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamStats> getTeamInsights() {

        return teamService.getTeamInsights();
    }

}
