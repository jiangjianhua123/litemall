package org.linlinjava.litemall.wx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

/**
 * 验证码实体类，用于缓存验证码发送
 */
@Data
@ApiModel("密码找回模型")
public class CaptchaEmail {

    @NonNull
    private String email;
    @NonNull
    private String code;
    @NonNull
    private String password;
}