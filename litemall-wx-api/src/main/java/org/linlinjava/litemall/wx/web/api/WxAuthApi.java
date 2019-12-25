package org.linlinjava.litemall.wx.web.api;

import io.swagger.annotations.Api;
import org.linlinjava.litemall.wx.annotation.LoginUser;
import org.linlinjava.litemall.wx.dto.WxLoginInfo;
import org.linlinjava.litemall.wx.web.model.UserRegisterDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

public interface WxAuthApi {

    Object login(@RequestBody String body, HttpServletRequest request);

    Object loginByWeixin(@RequestBody WxLoginInfo wxLoginInfo, HttpServletRequest request);

    Object registerCaptcha(@RequestBody String body);

    Object register(@RequestBody UserRegisterDTO userRegisterDTO, HttpServletRequest request);

    Object captcha(@LoginUser Integer userId, @RequestBody String body);

    Object reset(@RequestBody String body, HttpServletRequest request);

    Object resetPhone(@LoginUser Integer userId, @RequestBody String body, HttpServletRequest request);

    Object profile(@LoginUser Integer userId, @RequestBody String body, HttpServletRequest request);

    Object bindPhone(@LoginUser Integer userId, @RequestBody String body);

    Object logout(@LoginUser Integer userId);

    Object info(@LoginUser Integer userId);
}
