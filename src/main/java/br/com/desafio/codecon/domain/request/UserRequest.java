package br.com.desafio.codecon.domain.request;

import java.util.List;

public record UserRequest(
        String id,
        String name,
        int age,
        int score,
        boolean active,
        String country,
        Team team,
        List<Log> logs
) {}