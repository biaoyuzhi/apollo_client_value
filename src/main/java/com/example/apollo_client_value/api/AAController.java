package com.example.apollo_client_value.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wuzh on 2020/6/7.
 * Description:
 */
@RestController
public class AAController {

    @Autowired
    // 注入@Bean注解的Map<String,String>对象，当有多个@Bean注解的Map<String,String>对象时，下面申明的属性名需要和@Bean注解的方法名一一对应
    private Map<String,String> aa;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private CacheServer cacheServer;

    @GetMapping
    public String index(){
        return aa.get("1");
    }

    @GetMapping("/redis")
    public String redis(){
        redisTemplate.opsForValue().set("aa", "xx");
        return "success";
    }

    @GetMapping("/cache")
    public String cache(){
        return cacheServer.setCache(2);
    }

}
