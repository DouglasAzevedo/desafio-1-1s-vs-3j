package br.com.desafio.codecon.domain.response.user;

import br.com.desafio.codecon.domain.request.UserRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SuperUsersResponse {

    List<UserRequest> superUsers;

}
