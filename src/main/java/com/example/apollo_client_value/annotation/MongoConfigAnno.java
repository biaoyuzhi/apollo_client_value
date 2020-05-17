package com.example.apollo_client_value.annotation;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 方式一：注解方式实时读取Apollo配置中心的设置
 */
@Configuration
@EnableApolloConfig({"mongo"})  // 指定namespace为mongo
public class MongoConfigAnno {
    
    @ApolloConfig("mongo") //inject config for namespace mongo，等同于api方式的ConfigService.getConfig("mongo")
    private Config config;

    @Value("${mongo.host:localhost}")   // key为mongo.host
    private String host;

    @Value("${mongo.port:1234}")    // key为mongo.port
    private String port;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    @ApolloConfigChangeListener("mongo")    // 设置监听器，实现实时更新功能
    private void someOnChange(ConfigChangeEvent changeEvent){
        
        if(changeEvent.isChanged("mongo.host")){
            this.host = config.getProperty("mongo.host","defaultValue");
        }
        if(changeEvent.isChanged("mongo.port")){
            this.port = config.getProperty("mongo.port","1234");
        }
        
    }

    @Override
    public String toString() {
        return String.format("mongo configuration--- host: %s  port: %s",this.host,this.port);
    }
}
