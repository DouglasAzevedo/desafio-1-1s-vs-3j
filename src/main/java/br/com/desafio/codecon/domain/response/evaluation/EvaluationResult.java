package br.com.desafio.codecon.domain.response.evaluation;

public record EvaluationResult(
        String endpoint,
        boolean statusOk,
        long responseTimeMs,
        boolean validJson
) {}
