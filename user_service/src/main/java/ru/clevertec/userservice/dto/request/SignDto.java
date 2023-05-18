package ru.clevertec.userservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignDto {

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

}
