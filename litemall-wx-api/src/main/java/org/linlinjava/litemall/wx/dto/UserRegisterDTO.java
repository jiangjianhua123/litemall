package org.linlinjava.litemall.wx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@ApiModel("user register model")
public class UserRegisterDTO {

    @ApiModelProperty(value = "Email is required", required = true)
    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @ApiModelProperty(value = "name is required", required = true)
    private String username;

    @ApiModelProperty(value = "password is required", required = true)
    private String password;

    @ApiModelProperty(value = "code is required", required = true)
    private String code;

    @ApiModelProperty
    private String ip;

}
