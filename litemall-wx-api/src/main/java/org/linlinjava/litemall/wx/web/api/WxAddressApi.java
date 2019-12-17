package org.linlinjava.litemall.wx.web.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.linlinjava.litemall.db.domain.LitemallAddress;
import org.linlinjava.litemall.wx.annotation.LoginUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;


public interface WxAddressApi {
    @GetMapping("list")
    Object list(@LoginUser Integer userId);

    @GetMapping("detail")
    Object detail(@LoginUser Integer userId, @NotNull Integer id);

    @PostMapping("save")
    Object save(@LoginUser Integer userId, @RequestBody LitemallAddress address);

    @PostMapping("delete")
    Object delete(@LoginUser Integer userId, @RequestBody LitemallAddress address);
}
