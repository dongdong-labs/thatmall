package org.onedayday.framework.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author wdd
 */
@Component
public class KeySerializer extends StringRedisSerializer {


    @Value("${settings.redis.keyPrefix:}")
    private String keyPrefix;

    private final Charset charset;

    /**
     * {@link StringRedisSerializer} to use 7 bit ASCII, a.k.a. ISO646-US, a.k.a. the Basic Latin block of the Unicode
     * character set.
     *
     * @see StandardCharsets#US_ASCII
     * @since 2.1
     */
    public static final StringRedisSerializer US_ASCII = new StringRedisSerializer(StandardCharsets.US_ASCII);

    /**
     * {@link StringRedisSerializer} to use ISO Latin Alphabet No. 1, a.k.a. ISO-LATIN-1.
     *
     * @see StandardCharsets#ISO_8859_1
     * @since 2.1
     */
    public static final StringRedisSerializer ISO_8859_1 = new StringRedisSerializer(StandardCharsets.ISO_8859_1);

    /**
     * {@link StringRedisSerializer} to use 8 bit UCS Transformation Format.
     *
     * @see StandardCharsets#UTF_8
     * @since 2.1
     */
    public static final StringRedisSerializer UTF_8 = new StringRedisSerializer(StandardCharsets.UTF_8);

    /**
     * Creates a new {@link StringRedisSerializer} using {@link StandardCharsets#UTF_8 UTF-8}.
     */
    public KeySerializer() {
        this(StandardCharsets.UTF_8);
    }

    /**
     * Creates a new {@link StringRedisSerializer} using the given {@link Charset} to encode and decode strings.
     *
     * @param charset must not be {@literal null}.
     */
    public KeySerializer(Charset charset) {

        Assert.notNull(charset, "Charset must not be null!");
        this.charset = charset;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.redis.serializer.RedisSerializer#deserialize(byte[])
     */
    @Override
    public String deserialize(@Nullable byte[] bytes) {
        return (bytes == null ? null : new String(bytes, charset));
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.redis.serializer.RedisSerializer#serialize(java.lang.Object)
     */

    @Override
    public Class<?> getTargetType() {
        return String.class;
    }

    @Override
    public byte[] serialize(@Nullable String string) {

        String key = keyPrefix + string;
        return (key == null ? null : key.getBytes(charset));
    }

}
