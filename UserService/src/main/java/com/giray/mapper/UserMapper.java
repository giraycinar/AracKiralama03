package com.giray.mapper;

import com.giray.dto.request.CreateUserRequestDto;
import com.giray.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User fromCreateRequestToUser(final CreateUserRequestDto dto);




}
