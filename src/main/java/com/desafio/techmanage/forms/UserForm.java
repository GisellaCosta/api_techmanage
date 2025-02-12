package com.desafio.techmanage.forms;

import com.desafio.techmanage.enums.UserType;
import com.desafio.techmanage.models.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class UserForm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "O campo 'fullName' não pode estar vazio")
    @Length(min = 3, max = 100)
    private String fullName;

    @NotNull(message = "O campo 'email' não pode estar vazio")
    @Email(message = "O email fornecido não é válido")
    @Length(min = 5, max = 100)
    private String email;

    @NotNull(message = "O campo 'phone' não pode estar vazio")
    @Length(min = 10, max = 15)
    @Pattern(
            regexp = "^\\+\\d{1,3}\\s?\\d{1,4}[\\s-]?\\d{4,}$",
            message = "Número de telefone inválido. Use o formato internacional, ex: +55 11 99999-9999"
    )
    private String phone;

    @NotNull(message = "O campo 'birthDate' não pode estar vazio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;

    @NotNull(message = "O campo 'userType' não pode estar vazio")
    @Pattern(regexp = "ADMIN|EDITOR|VIEWER", message = "Tipo de usuário inválido! Os valores aceitos são: ADMIN, EDITOR, VIEWER.")
    @Enumerated(EnumType.STRING)
    private String  userType;

    public UserForm(Long id,String fullName, String email, String phone, Date birthDate, String userType) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String  getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public User toModel() {
        User user = new User();
        user.setEmail(email);
        user.setUserType(UserType.valueOf(userType.toUpperCase()));
        user.setBirthDate(birthDate);
        user.setFullName(fullName);
        user.setPhone(phone);

        return user;
    }

}
