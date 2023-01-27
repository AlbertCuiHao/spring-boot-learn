package com.example.learnweb.info;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserInfoVo {
    @NotBlank
    private String userName;
    private String sex;
    @NotBlank
    @Pattern(regexp = "^[0-9]\\d[1-9]$", message = "格式错误")
    private String age;


}
