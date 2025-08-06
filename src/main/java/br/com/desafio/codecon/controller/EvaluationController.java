package br.com.desafio.codecon.controller;

import br.com.desafio.codecon.domain.response.evaluation.EvaluationReport;
import br.com.desafio.codecon.service.EvaluationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping
    public EvaluationReport runEvaluation() {
        return evaluationService.runEvaluation();
    }

}