package br.com.desafio.codecon.domain.response.team;

import java.math.BigDecimal;

public record TeamStats(
        String team,
        long total_members,
        long leaders,
        long completed_projects,
        BigDecimal active_percentage
) {}