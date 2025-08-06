package br.com.desafio.codecon.component;

import br.com.desafio.codecon.domain.request.UserRequest;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class UserCache {

    private final List<UserRequest> users = new ArrayList<>();

    public void setUsers(List<UserRequest> usersRequest) {
        users.addAll(usersRequest);
    }

}
