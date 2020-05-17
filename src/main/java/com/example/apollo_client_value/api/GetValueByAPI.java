package com.example.apollo_client_value.api;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 方式二：api方式实时读取Apollo配置中心的设置
 */
@Component
public class GetValueByAPI {

    @PostConstruct
    public String getValue(){
        Config config = ConfigService.getAppConfig();   // 默认namespace为application
//        Config config1 = ConfigService.getConfig("mongo");    // 指定namespace为mongo
        String value = config.getProperty("changeKey","apollo_client"); // 获取key为changeKey的值。如果网络不通或没有找到key，返回apollo_client
        return String.format("value is %s",value);
    }
}
