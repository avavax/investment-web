package com.investment.forms;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
public class UserForm {
    @NotEmpty
    @Length(max = 16, min = 5)
    private String name;
    @Email
    private String email;
    @NotEmpty
    @Length(max = 16, min = 5)
    private String password;
    @NotEmpty
    @Length(max = 16, min = 5)
    private String repeatPassword;
}
