package com.giray.service;

import com.giray.dto.request.RegisterRequestDto;
import com.giray.entity.Auth;
import com.giray.repository.AuthRepository;
import com.giray.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class AuthService extends ServiceManager<Auth, Long> {
    private final AuthRepository authRepository;

    public AuthService(JpaRepository<Auth, Long> repository, AuthRepository authRepository) {
        super(repository);
        this.authRepository = authRepository;
    }


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
