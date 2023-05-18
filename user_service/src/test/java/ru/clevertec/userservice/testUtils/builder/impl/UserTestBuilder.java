package ru.clevertec.userservice.testUtils.builder.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import ru.clevertec.userservice.dto.request.LoginDto;
import ru.clevertec.userservice.dto.request.SignDto;
import ru.clevertec.userservice.dto.request.UserCreateDto;
import ru.clevertec.userservice.repository.entity.User;
import ru.clevertec.userservice.repository.entity.enums.ERole;
import ru.clevertec.userservice.repository.entity.enums.EStatus;
import ru.clevertec.userservice.security.UserDetailsUser;
import ru.clevertec.clevertec_final.testUtils.builder.TestBuilder;


import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static ru.clevertec.clevertec_final.testUtils.TestUtils.getRandomEnum;
import static ru.clevertec.clevertec_final.testUtils.TestUtils.getRandomString;


@With
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTestBuilder implements TestBuilder<User> {

    private UUID uuid;
    private Instant createDate;
    private Instant updateDate;
    private String mail;
    private String nick;
    private ERole role;
    private EStatus status;
    private String password;


    public static UserTestBuilder defaultValues(){
        UserTestBuilder userTestBuilder = new UserTestBuilder();

        userTestBuilder.setUuid(UUID.fromString("96966e15-fc8f-4c53-9056-ccbf36a865f9"));
        userTestBuilder.setCreateDate(Instant.MAX);
        userTestBuilder.setUpdateDate(Instant.MAX);
        userTestBuilder.setMail("test1@gmail.com");
        userTestBuilder.setNick("user1");
        userTestBuilder.setRole(ERole.ADMIN);
        userTestBuilder.setStatus(EStatus.ACTIVATED);
        userTestBuilder.setPassword("test");


        return userTestBuilder;
    }

    public static UserTestBuilder randomValues(){
        UserTestBuilder userTestBuilder = new UserTestBuilder();

        userTestBuilder.setUuid(UUID.randomUUID());
        userTestBuilder.setCreateDate(Instant.now());
        userTestBuilder.setUpdateDate(Instant.now());
        userTestBuilder.setMail(getRandomString());
        userTestBuilder.setNick(getRandomString());
        userTestBuilder.setRole(getRandomEnum(ERole.class));
        userTestBuilder.setStatus(getRandomEnum(EStatus.class));
        userTestBuilder.setPassword(getRandomString());

        return userTestBuilder;
    }

    public UserCreateDto buildCreateDto(){

        return UserCreateDto.builder()
                .setMail(this.getMail())
                .setNick(this.getNick())
                .setRole(this.getRole().name())
                .setStatus(this.getStatus().name())
                .setPassword(this.getPassword())
                .build();
    }

    public static UserCreateDto toCreateDto(User user){

        return UserCreateDto.builder()
                .setMail(user.getMail())
                .setNick(user.getNick())
                .setRole(user.getRole().name())
                .setStatus(user.getStatus().name())
                .setPassword(user.getPassword())
                .build();
    }


    public static LoginDto toLoginDto(User user){
        return LoginDto.builder()
                .nick(user.getNick())
                .password(user.getPassword())
                .build();
    }


    public static SignDto toSignDto(User user){
        return SignDto.builder()
                .mail(user.getMail())
                .nick(user.getNick())
                .password(user.getPassword())
                .build();
    }

    public static UserDetailsUser toUserDetailsUser(User user){
        return UserDetailsUser.builder()
                .setUuid(user.getUuid())
                .setUsername(user.getNick())
                .setMail(user.getMail())
                .setPassword(user.getPassword())
                .setAuthorities(List.of(user.getRole()))
                .setAccountNonExpired(true)
                .setAccountNonLocked(EStatus.ACTIVATED.equals(user.getStatus()))
                .setEnabled(EStatus.ACTIVATED.equals(user.getStatus()))
                .build();
    }

    @Override
    public User build(){
        User user = new User();
        user.setUuid(uuid);
        user.setCreateDate(createDate);
        user.setUpdateDate(updateDate);
        user.setMail(mail);
        user.setNick(nick);
        user.setRole(role);
        user.setStatus(status);
        user.setPassword(password);

        return user;
    }

}
