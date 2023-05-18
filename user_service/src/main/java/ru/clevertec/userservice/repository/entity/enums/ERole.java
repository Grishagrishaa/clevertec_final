package ru.clevertec.userservice.repository.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum ERole implements GrantedAuthority {
    USER,
    ADMIN,
    JOURNALIST;

    @Override
    public String getAuthority() {
        return name();
    }
}
