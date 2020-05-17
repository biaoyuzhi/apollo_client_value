package com.example.apollo_client_value.controller;

import com.example.apollo_client_value.annotation.MongoConfigAnno;
import com.example.apollo_client_value.api.GetValueByAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuzh on 2020/5/17.
 * Description: 提供url接口实时查看配置值
 */
@RestController
public class AAController {
    @Autowired
    private MongoConfigAnno anno;
    @Autowired
    private GetValueByAPI api;

    @GetMapping("/index")
    public String getIndex(){
        return anno.toString() + ",,, " + api.getValue();
    }
}
