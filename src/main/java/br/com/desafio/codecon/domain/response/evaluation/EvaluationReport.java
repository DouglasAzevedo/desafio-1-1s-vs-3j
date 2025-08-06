package br.com.desafio.codecon.domain.response.evaluation;

import java.util.List;

public record EvaluationReport(
        List<EvaluationResult> results
) {}
