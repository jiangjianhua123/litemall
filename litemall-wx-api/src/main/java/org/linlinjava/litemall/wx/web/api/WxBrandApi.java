package org.linlinjava.litemall.wx.web.api;

import io.swagger.annotations.Api;
import org.linlinjava.litemall.core.validator.Order;
import org.linlinjava.litemall.core.validator.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

public interface WxBrandApi {
    Object list(@RequestParam(defaultValue = "1") Integer page,
                @RequestParam(defaultValue = "10") Integer limit,
                @Sort @RequestParam(defaultValue = "add_time") String sort,
                @Order @RequestParam(defaultValue = "desc") String order);

    Object detail(@NotNull Integer id);
}
