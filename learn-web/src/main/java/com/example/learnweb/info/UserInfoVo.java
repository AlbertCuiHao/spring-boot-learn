package com.example.learnweb.info;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserInfoVo {
    @NotBlank
    private String userName;
    private String sex;
    @NotBlank
    @Pattern(regexp = "^[1-9]\\d*$", message = "格式错误")
    private String age;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
