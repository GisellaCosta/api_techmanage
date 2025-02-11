package com.desafio.techmanage.vo;

import com.desafio.techmanage.models.User;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable {

    private String fullName;
    private String email;
    private String phone;
    private Date birthDate;
    private String userType;

    public UserVO(String fullName, String email, String phone, Date birthDate, String userType) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    public UserVO() {
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public static UserVO fromModel(User user) {
        UserVO userVO = new UserVO();
        userVO.setEmail(user.getEmail());
        userVO.setUserType(user.getUserType());
        userVO.setBirthDate(user.getBirthDate());
        userVO.setFullName(user.getFullName());
        userVO.setPhone(user.getPhone());

        return userVO;
    }
}
