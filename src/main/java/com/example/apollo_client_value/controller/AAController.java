package com.example.apollo_client_value.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuzh on 2020/5/17.
 * Description: 提供url接口实时查看配置值
 */
@Api(value = "图书", tags = "图书")
@RestController
public class AAController {

    @ApiOperation(value = "腾讯ISBN图书查询")
    @GetMapping("/index")
    public String getIndex(){
        return "find me!";
    }
}
