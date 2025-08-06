package br.com.desafio.codecon.service;

import br.com.desafio.codecon.component.EvaluationEndpointComponent;
import br.com.desafio.codecon.domain.response.evaluation.EvaluationReport;
import br.com.desafio.codecon.domain.response.evaluation.EvaluationResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EvaluationService {

    private final RestTemplate restTemplate;

    private final EvaluationEndpointComponent evaluationEndpoint;

    public EvaluationService(EvaluationEndpointComponent evaluationEndpoin) {
        this.evaluationEndpoint = evaluationEndpoin;
        this.restTemplate = new RestTemplate();
    }

    public EvaluationReport runEvaluation() {

        List<EvaluationResult> results = evaluationEndpoint.getEndpointsEvaluation().stream()
                .map(this::evaluateResult)
                .toList();

        return new EvaluationReport(results);
    }

    private EvaluationResult evaluateResult(String url) {

        long startTime = System.currentTimeMillis();

        boolean validJson;

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            long responseTime = System.currentTimeMillis() - startTime;

            try {
                new ObjectMapper().readTree(response.getBody());
                validJson = true;
            } catch (Exception e) {
                validJson = false;
            }

            return new EvaluationResult(
                    url,
                    response.getStatusCode().is2xxSuccessful(),
                    responseTime,
                    validJson
            );

        } catch (Exception ex) {
            long responseTime = System.currentTimeMillis() - startTime;
            return new EvaluationResult(
                    url,
                    false,
                    responseTime,
                    false
            );
        }

    }



}
