package com.giray.service;

import com.giray.dto.request.RegisterRequestDto;
import com.giray.dto.response.RegisterResponseDto;
import com.giray.entity.Auth;
import com.giray.mapper.AuthMapper;
import com.giray.repository.AuthRepository;
import com.giray.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@RequiredArgsConstructor
public class AuthService extends ServiceManager<Auth, Long> {
    private final AuthRepository authRepository;


    public AuthService(JpaRepository<Auth, Long> repository, AuthRepository authRepository) {
        super(repository);
        this.authRepository = authRepository;
    }


    @Transactional
    public RegisterResponseDto register(RegisterRequestDto dto) {
        Auth auth = AuthMapper.INSTANCE.fromRegisterRequestToAuth(dto);
//        auth.setActivationCode(CodeGenerator.generateCode());
        save(auth);
//        try {
//        userManager.createUser(AuthMapper.INSTANCE.fromAuthToCreateUserRequestDto(auth));
//        cacheManager.getCache("findByRole").evict(auth.getRole().toString().toUpperCase());
//        } catch (Exception e){
//            e.printStackTrace();
//            delete(auth);
//        }
        return AuthMapper.INSTANCE.fromAuthToRegisterResponseDto(auth);
    }

//    public Boolean register(RegisterRequestDto dto) {
//        Auth auth = Auth.builder()
//                .password(dto.getPassword())
//                .email(dto.getEmail())
//                .username(dto.getUsername())
//                .createAt(System.currentTimeMillis())
//                .updateAt(System.currentTimeMillis())
//                .isActive(true)
//                .build();
//        authRepository.save(auth);
//
//        return true;
//    }
}
