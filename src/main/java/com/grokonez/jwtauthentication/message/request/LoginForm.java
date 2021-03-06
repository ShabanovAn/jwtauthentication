package com.grokonez.jwtauthentication.message.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginForm {
    @NotBlank
    @Size(min =3, max = 60)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
