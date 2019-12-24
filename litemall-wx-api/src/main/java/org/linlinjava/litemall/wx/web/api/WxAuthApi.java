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
    @PostMapping("login")
    Object login(@RequestBody String body, HttpServletRequest request);

    @PostMapping("login_by_weixin")
    Object loginByWeixin(@RequestBody WxLoginInfo wxLoginInfo, HttpServletRequest request);

    @PostMapping("regCaptcha")
    Object registerCaptcha(@RequestBody String body);

    @PostMapping("register")
    Object register(@RequestBody UserRegisterDTO userRegisterDTO, HttpServletRequest request);

    @PostMapping("captcha")
    Object captcha(@LoginUser Integer userId, @RequestBody String body);

    @PostMapping("reset")
    Object reset(@RequestBody String body, HttpServletRequest request);

    @PostMapping("resetPhone")
    Object resetPhone(@LoginUser Integer userId, @RequestBody String body, HttpServletRequest request);

    @PostMapping("profile")
    Object profile(@LoginUser Integer userId, @RequestBody String body, HttpServletRequest request);

    @PostMapping("bindPhone")
    Object bindPhone(@LoginUser Integer userId, @RequestBody String body);

    @PostMapping("logout")
    Object logout(@LoginUser Integer userId);

    @GetMapping("info")
    Object info(@LoginUser Integer userId);
}
