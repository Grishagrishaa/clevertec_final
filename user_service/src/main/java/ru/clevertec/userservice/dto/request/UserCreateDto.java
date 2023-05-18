package ru.clevertec.userservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.clevertec.userservice.repository.entity.enums.ERole;
import ru.clevertec.userservice.repository.entity.enums.EStatus;
import ru.clevertec.userservice.service.validators.api.ValueOfEnum;


@Data
@Builder(setterPrefix = "set")
@AllArgsConstructor @NoArgsConstructor
public class UserCreateDto {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 10)
    private String nick;

    @Email
    private String mail;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 15)
    private String password;

    @ValueOfEnum(enumClass = ERole.class)
    private String role;

    @ValueOfEnum(enumClass = EStatus.class)
    private String status;

}
