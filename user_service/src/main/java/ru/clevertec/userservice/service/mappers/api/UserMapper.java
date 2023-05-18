package ru.clevertec.userservice.service.mappers.api;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.clevertec.userservice.dto.request.SignDto;
import ru.clevertec.userservice.dto.request.UserCreateDto;
import ru.clevertec.userservice.repository.entity.User;
import ru.clevertec.userservice.repository.entity.enums.ERole;
import ru.clevertec.userservice.repository.entity.enums.EStatus;
import ru.clevertec.userservice.security.UserDetailsUser;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        imports = {EStatus.class, ERole.class, List.class})
public abstract class UserMapper {

    @Autowired
    protected PasswordEncoder encoder;

    @Mapping(target = "password", expression = "java(encoder.encode(source.getPassword()))")
    @Mapping(target = "status", expression = "java(source.getStatus() == null ? EStatus.WAITING_ACTIVATION : " +
                                                                               "EStatus.valueOf(source.getStatus()))")
    public abstract User userCreateDtoToUser(UserCreateDto source);

    @Mapping(target = "role", expression =  "java(ERole.USER.name())")
    @Mapping(target = "status", expression = "java(EStatus.ACTIVATED.name())")
    public abstract UserCreateDto signDtoToUserCreateDto(SignDto signDto);

    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "authorities", expression =  "java(List.of(user.getRole()))")
    @Mapping(target = "accountNonLocked", expression =  "java(EStatus.ACTIVATED.equals(user.getStatus()))")
    @Mapping(target = "enabled", expression =  "java(EStatus.ACTIVATED.equals(user.getStatus()))")
    @Mapping(target = "username", source = "nick")
    public abstract UserDetailsUser userToUserDetailsUser(User user);

    @Mapping(target = "password", expression = "java(encoder.encode(updateDto.getPassword()))")
    public abstract void update(@MappingTarget User entity, UserCreateDto updateDto);

}
