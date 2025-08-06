package br.com.desafio.codecon.domain.response.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TopCountriesResponse {

    private String country;

    private Long total;
}
