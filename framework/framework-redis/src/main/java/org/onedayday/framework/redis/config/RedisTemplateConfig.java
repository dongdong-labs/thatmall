package org.onedayday.framework.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import javax.annotation.Resource;

/**
 * @program:
 * @class: RedisTemplateConfig
 * @description:
 * @author: wdd
 * @create: 2020-08-14 09:54
 */
@Configuration
public class RedisTemplateConfig {

    @Resource
    private KeySerializer keySerializer;

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 1.创建 redisTemplate 模版
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        // 2.关联 redisConnectionFactory
        template.setConnectionFactory(redisConnectionFactory);
        // 3.创建 序列化类
        GenericToStringSerializer genericToStringSerializer = new GenericToStringSerializer(Object.class);
        // 6.序列化类，对象映射设置
        // 7.设置 value 的转化格式和 key 的转化格式
        template.setValueSerializer(genericToStringSerializer);

        template.setKeySerializer(keySerializer);
//        template.setHashKeySerializer(genericToStringSerializer);
//        template.setHashValueSerializer(genericToStringSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
