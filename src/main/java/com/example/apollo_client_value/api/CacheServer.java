package com.example.apollo_client_value.api;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wuzh on 2020/6/7.
 * Description:
 */
@Configuration
public class CacheServer {

    // value值设置需要和返回值类型一致
    // eg：前端传的id=2，调用该setCache方法后，redis缓存中：key=String::2，value=zzz，ttl=60000ms
    @Cacheable(value = "String", key = "#id")
    public String setCache(Integer id) {
        return "zzz";
    }

}
