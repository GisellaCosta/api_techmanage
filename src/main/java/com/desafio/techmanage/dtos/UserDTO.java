package com.desafio.techmanage.dtos;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {

    private String fullName;
    private String email;
    private String phone;
    private Date birthDate;
    private String userType;
}
