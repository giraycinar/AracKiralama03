package com.giray.mapper;

import com.giray.dto.request.CreateUserRequestDto;
import com.giray.dto.request.RegisterRequestDto;
import com.giray.dto.response.RegisterResponseDto;
import com.giray.entity.Auth;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {

    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    Auth fromRegisterRequestToAuth(final RegisterRequestDto dto);
    RegisterResponseDto fromAuthToRegisterResponseDto(final Auth auth);

    @Mapping(source = "id" , target = "authId")
    CreateUserRequestDto fromAuthToCreateUserRequestDto(final Auth auth);

//    @Mapping(source = "id", target ="authId")
//    RegisterModel fromAuthToRegisterModel(Auth auth);
}
