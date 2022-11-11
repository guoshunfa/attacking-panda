package com.panda.framework.filter.dto;

/**
 * @className: UserDTO
 * @author: GuoShunFa
 * @date: 2022/11/11
 **/
public class UserDTO {

    private String userName;

    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
