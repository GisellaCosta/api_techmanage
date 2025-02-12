package com.desafio.techmanage.vo;

import com.desafio.techmanage.enums.UserType;
import com.desafio.techmanage.models.User;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private Date birthDate;
    private UserType userType;

    public UserVO(Long id, String fullName, String email, String phone, Date birthDate, UserType userType) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    public UserVO() {
    }

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

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public static UserVO fromModel(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setEmail(user.getEmail());
        userVO.setUserType(user.getUserType());
        userVO.setBirthDate(user.getBirthDate());
        userVO.setFullName(user.getFullName());
        userVO.setPhone(user.getPhone());

        return userVO;
    }
}
