package br.com.desafio.codecon.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EvaluationEndpointComponent {

    @Value("${url.base}")
    private String urlBase;

    public List<String> getEndpointsEvaluation() {
        return List.of(
                urlBase.concat("/user/superusers"),
                urlBase.concat("/user/top-countries"),
                urlBase.concat("/team-insights"),
                urlBase.concat("/active-users-per-day")
        );
    }

}
