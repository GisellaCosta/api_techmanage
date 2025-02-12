package com.desafio.techmanage.models;

import com.desafio.techmanage.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import java.util.Date;

@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
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

    @Column(name = "birth_date")
    @NotNull(message = "O campo 'birthDate' não pode estar vazio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;


    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo 'userType' não pode estar vazio")
    private UserType userType;

    public User(String fullName, String email, String phone, Date birthDate,  UserType userType) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    public User(Long id, String fullName, String email, String phone, Date birthDate,  UserType userType) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public UserType getUserType() {
        return userType;
    }

    public void setUserType( UserType userType) {
        this.userType = userType;
    }


}