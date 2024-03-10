package com.giray.controller;

import com.giray.dto.request.CreateUserRequestDto;
import com.giray.entity.User;
import com.giray.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.giray.constant.RestApiUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(USER) //http://localhost:7071/api/v1/user
public class UserController {
    private final UserService userService;


    @PostMapping(CREATE)
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequestDto dto){
        return ResponseEntity.ok(userService.createUser(dto));

    }

    @GetMapping(ACTIVATE_STATUS+"/{authId}")
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authId){
        return ResponseEntity.ok(userService.activateStatus(authId));
    }

}
