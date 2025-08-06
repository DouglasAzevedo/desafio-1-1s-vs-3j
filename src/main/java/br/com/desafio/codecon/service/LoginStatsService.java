package br.com.desafio.codecon.service;

import br.com.desafio.codecon.component.UserCache;
import br.com.desafio.codecon.domain.request.Log;
import br.com.desafio.codecon.domain.response.log.LoginStatsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoginStatsService {

    private final UserCache userCache;

    public LoginStatsService(UserCache userCache) {
        this.userCache = userCache;
    }

    public List<LoginStatsResponse> getActiveUsersPerDay(Integer min) {
        Map<String, Long> loginsByDate = userCache.getUsers().stream()
                .flatMap(user -> user.logs().stream())
                .filter(log -> "login".equalsIgnoreCase(log.action()))
                .collect(Collectors.groupingBy(Log::date, Collectors.counting()));

        return loginsByDate.entrySet().stream()
                .filter(entry -> min == null || entry.getValue() >= min)
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> new LoginStatsResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

}
