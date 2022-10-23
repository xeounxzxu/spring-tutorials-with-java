package com.example.app.web;

import com.example.app.domain.user.User;
import com.example.app.service.dto.JoinDTO;
import com.example.app.service.user.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final JoinService joinService;

    @PostMapping
    public User joinUser(@RequestBody JoinDTO dto) {
        return joinService.join(dto);
    }
}