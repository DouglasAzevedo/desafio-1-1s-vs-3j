package br.com.desafio.codecon.controller;

import br.com.desafio.codecon.domain.request.UserRequest;
import br.com.desafio.codecon.domain.response.user.SuperUsersResponse;
import br.com.desafio.codecon.domain.response.user.TopCountriesResponse;
import br.com.desafio.codecon.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUsers(@RequestBody List<UserRequest> request) {
        userService.setUsersCache(request);
        ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public List<UserRequest> listUsers() {

        return userService.getUserCache();
    }

    @GetMapping("/superusers")
    public SuperUsersResponse getSuperUsers() {

        return userService.findSuperUsers();
    }

    @GetMapping("/top-countries")
    public List<TopCountriesResponse> listTopCountries() {

        return userService.getTopCountries();
    }

}
