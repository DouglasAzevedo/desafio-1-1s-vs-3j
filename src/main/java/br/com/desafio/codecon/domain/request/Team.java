package br.com.desafio.codecon.domain.request;

import java.util.List;

public record Team(
        String name,
        boolean leader,
        List<Project> projects
) {}