package org.onedayday.framework.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * redis锁
 *
 * @author wdd
 */
@Component
public class RedisLockUtil {

    @Resource
    private RedisTemplate redisTemplate;


    /***
     * 单一key加锁，过期时间秒
     * @param key
     * @param seconds
     * @return
     */
    public Boolean lockForTime(String key, Long seconds) {
        return redisTemplate.opsForValue().setIfAbsent(key, key, seconds.longValue(), TimeUnit.SECONDS);
    }


    /***
     * 单一key加锁，没有过期时间
     * @param key
     * @return
     */
    public Boolean lock(String key) {
        return redisTemplate.opsForValue().setIfAbsent(key, key);
    }

    /****
     * 对象加锁，过期时间秒
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public Boolean lockForTime(String key, Object value, Long seconds) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, seconds.longValue(), TimeUnit.SECONDS);

    }

    /***
     * 解锁
     * @param key
     * @return
     */
    public Boolean del(String key) {
        return redisTemplate.delete(key);
    }
}
