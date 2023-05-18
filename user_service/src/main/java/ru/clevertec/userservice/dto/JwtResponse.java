package ru.clevertec.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@FieldNameConstants
@AllArgsConstructor(staticName = "of")
public class JwtResponse {

    private String username;
    private Collection<? extends GrantedAuthority> authorities;
    private Boolean activated;
    private String jwtToken;
    private final String type = "Bearer";

}
