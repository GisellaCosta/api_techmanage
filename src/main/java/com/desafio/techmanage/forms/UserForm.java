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

    public @NotNull @Length(min = 5, max = 100) String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Length(min = 5, max = 100) String email) {
        this.email = email;
    }

    @Nullable
    public @Length(min = 10, max = 15) String getPhone() {
        return phone;
    }

    public void setPhone(@Nullable @Length(min = 10, max = 15) String phone) {
        this.phone = phone;
    }

    public @NotNull @Length(min = 3, max = 100) String getFullName() {
        return fullName;
    }

    public void setFullName(@NotNull @Length(min = 3, max = 100) String fullName) {
        this.fullName = fullName;
    }

    public @NotNull Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotNull Date birthDate) {
        this.birthDate = birthDate;
    }

    @Nullable
    public @Length(min = 5, max = 10) String getUserType() {
        return userType;
    }

    public void setUserType(@Nullable @Length(min = 5, max = 10) String userType) {
        this.userType = userType;
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
