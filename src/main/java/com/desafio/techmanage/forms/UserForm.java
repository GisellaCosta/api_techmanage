package com.desafio.techmanage.forms;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class UserForm {

    @NotNull
    @Length(min = 3, max = 100)
    private String fullName;

    @NotNull
    @Length(min = 5, max = 100)
    private String email;

    @Nullable
    @Length(min = 10, max = 15)
    private String phone;

    @NotNull
    private Date birthDate;

    @Nullable
    @Length(min = 5, max = 10)
    private String userType;

}
