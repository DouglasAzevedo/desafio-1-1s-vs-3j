package br.com.desafio.codecon.service;

import br.com.desafio.codecon.component.UserCache;
import br.com.desafio.codecon.domain.request.Project;
import br.com.desafio.codecon.domain.request.UserRequest;
import br.com.desafio.codecon.domain.response.team.TeamStats;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final UserCache userCache;

    public TeamService(UserCache userCache) {
        this.userCache = userCache;
    }

    public List<TeamStats> getTeamInsights() {

        return userCache.getUsers().stream()
                .collect(Collectors.groupingBy(user -> user.team().name()))
                .entrySet().stream()
                .map(entry -> {
                    String teamName = entry.getKey();
                    List<UserRequest> teamMembers = entry.getValue();

                    long totalMembers = teamMembers.size();
                    long leaders = teamMembers.stream()
                            .filter(user -> user.team().leader())
                            .count();

                    long completedProjects = teamMembers.stream()
                            .flatMap(user -> user.team().projects().stream())
                            .filter(Project::completed)
                            .distinct()
                            .count();

                    long activeCount = teamMembers.stream()
                            .filter(UserRequest::active)
                            .count();

                    double activePercentage = totalMembers > 0 ?
                            (activeCount * 100.0) / totalMembers : 0.0;

                    return new TeamStats(
                            teamName,
                            totalMembers,
                            leaders,
                            completedProjects,
                            new BigDecimal(activePercentage).setScale(2, RoundingMode.HALF_UP)
                    );

                }).collect(Collectors.toList());
    }

}
