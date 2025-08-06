package br.com.desafio.codecon.service;

import br.com.desafio.codecon.component.UserCache;
import br.com.desafio.codecon.domain.request.UserRequest;
import br.com.desafio.codecon.domain.response.user.SuperUsersResponse;
import br.com.desafio.codecon.domain.response.user.TopCountriesResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserCache userCache;

    public UserService(UserCache userCache) {
        this.userCache = userCache;
    }

    public void setUsersCache(List<UserRequest> userRequests) {
        userCache.setUsers(userRequests);
    }

    public List<UserRequest> getUserCache() {
        return userCache.getUsers();
    }

    public SuperUsersResponse findSuperUsers() {

        List<UserRequest> usersFilter = getSuperUsers();

        SuperUsersResponse superUsersResponse = new SuperUsersResponse();
        superUsersResponse.setSuperUsers(usersFilter);

        return superUsersResponse;
    }

    private List<UserRequest> getSuperUsers() {
        return getUserCache().stream()
                .filter(userRequest -> userRequest.active() && userRequest.score() >= 900)
                .toList();
    }

    public List<TopCountriesResponse> getTopCountries() {

        return getSuperUsers().stream()
                .collect(Collectors.groupingBy(UserRequest::country, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(5)
                .map(entry -> new TopCountriesResponse(entry.getKey(), entry.getValue()))
                .toList();
    }

}
