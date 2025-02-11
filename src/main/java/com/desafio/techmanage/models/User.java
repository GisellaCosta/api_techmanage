package com.desafio.techmanage.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import java.util.Date;

@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Length(min = 3, max = 100)
    private String fullName;

    @NotNull
    @Length(min = 5, max = 100)
    private String email;

    @Nullable
    @Length(min = 10, max = 15)
    @Pattern(
            regexp = "^\\+\\d{1,3}\\s?\\d{1,4}[\\s-]?\\d{4,}$",
            message = "Número de telefone inválido. Use o formato internacional, ex: +55 11 99999-9999"
    )
    private String phone;

    @NotNull
    private Date birthDate;

    @Nullable
    @Length(min = 5, max = 10)
    private String userType;

    public User(String fullName, String email, String phone, Date birthDate, String userType) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    public User(Long id, String fullName, String email, String phone, Date birthDate, String userType) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    public User() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Nullable
    public String getPhone() {
        return phone;
    }

    public void setPhone(@Nullable String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Nullable
    public String getUserType() {
        return userType;
    }

    public void setUserType(@Nullable String userType) {
        this.userType = userType;
    }


}