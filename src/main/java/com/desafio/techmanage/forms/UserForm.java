package com.desafio.techmanage.forms;

import com.desafio.techmanage.models.User;
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

    public UserForm(String fullName, String email, String phone, Date birthDate, String userType) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User toModel() {
        User user = new User();
        user.setEmail(email);
        user.setUserType(userType);
        user.setBirthDate(birthDate);
        user.setFullName(fullName);
        user.setPhone(phone);

        return user;
    }

}
