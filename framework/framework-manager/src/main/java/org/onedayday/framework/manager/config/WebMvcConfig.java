package org.onedayday.framework.manager.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;


/**
 * @class: WebConfig
 * @description:
 * @author: wdd
 */
@Configuration
@EnableWebMvc
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = getFastJsonConfig();
        converter.setFastJsonConfig(config);
        converters.clear();
        converters.add(converter);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converters.add(stringHttpMessageConverter);
        log.info("返回值序列化格式初始化完成！");
    }

    private FastJsonConfig getFastJsonConfig() {
        //序列化配置
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                // 输出key时是否使用双引号
                QuoteFieldNames,
                //WriteMapNullValue,
                //数值字段如果为null,输出为0,而非null
                WriteNullNumberAsZero,
                //List字段如果为null,输出为[],而非null
                WriteNullListAsEmpty,

                WriteBigDecimalAsPlain,
                //字符类型字段如果为null,输出为"",而非null
                WriteNullStringAsEmpty,
                //Boolean字段如果为null,输出为false,而非null
                WriteNullBooleanAsFalse,
                //WriteNullStringAsEmpty,// null String不输出
                //WriteMapNullValue,//null String也要输出
                //Date的日期转换器
                WriteDateUseDateFormat,
                //禁止循环引用
                DisableCircularReferenceDetect
        );
        config.setSerializeFilters(new BigDecimalValueFilter());
        config.setSerializeConfig(getSerializeConfig());
        return config;
    }

    private SerializeConfig getSerializeConfig() {
        //自定义拦截器
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        return serializeConfig;
    }
}
