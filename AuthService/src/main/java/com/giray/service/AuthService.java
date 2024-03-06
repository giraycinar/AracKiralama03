package com.giray.service;

import com.giray.dto.request.RegisterRequestDto;
import com.giray.entity.Auth;
import com.giray.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;


    public Boolean register(RegisterRequestDto dto) {
        Auth auth = Auth.builder()
                .password(dto.getPassword())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .createAt(System.currentTimeMillis())
                .updateAt(System.currentTimeMillis())
                .isActive(true)
                .build();
        authRepository.save(auth);

        return true;
    }
}
