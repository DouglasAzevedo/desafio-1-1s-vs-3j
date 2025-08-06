package br.com.desafio.codecon.controller;

import br.com.desafio.codecon.domain.response.log.LoginStatsResponse;
import br.com.desafio.codecon.service.LoginStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/active-users-per-day")
public class LoginStatsController {

    private final LoginStatsService loginStatsService;

    public LoginStatsController(LoginStatsService loginStatsService) {
        this.loginStatsService = loginStatsService;
    }

    @GetMapping
    public List<LoginStatsResponse> getActiveUsersPerDay(Integer min) {

        return loginStatsService.getActiveUsersPerDay(min);
    }

}
