package br.com.desafio.codecon.domain.response.log;

public record LoginStatsResponse(
        String date,
        long total_logins
){}
