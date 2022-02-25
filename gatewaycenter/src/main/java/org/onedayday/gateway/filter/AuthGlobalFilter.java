package org.onedayday.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.onedayday.framework.utils.StringUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @program: gateway
 * @class: LoggingFilter
 * @description:
 * @author: wdd
 * @create: 2021-10-03 09:32
 */
@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info(String.format("Method:'%s' Host:'%s' Path:'%s' Query:%s", request.getMethod().name(), request.getURI().getHost(), request.getURI().getPath(), request.getQueryParams()));

        String token = request.getHeaders().getFirst("Authorization");

        if (StringUtil.isEmpty(token)) {
            return chain.filter(exchange);
        }

        String requestMethod = request.getMethodValue();

        if (HttpMethod.POST.toString().equals(requestMethod) || HttpMethod.PUT.toString().equals(requestMethod)) {
            return DataBufferUtils.join(exchange.getRequest().getBody()).flatMap(dataBuffer -> {
                byte[] bytes = new byte[dataBuffer.readableByteCount()];
                dataBuffer.read(bytes);
                String bodyStr = new String(bytes, StandardCharsets.UTF_8);
                exchange.getAttributes().put("body", bodyStr);
                DataBufferUtils.release(dataBuffer);
                Flux<DataBuffer> cachedFlux = Flux.defer(() -> {
                    DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
                    return Mono.just(buffer);
                });
                // 下面的将请求体再次封装写回到request里
                ServerHttpRequest serverHttpRequest = new ServerHttpRequestDecorator(exchange.getRequest()) {
                    @Override
                    public Flux<DataBuffer> getBody() {
                        return cachedFlux;
                    }
                };
                // 封装request，传给下一级
                return chain.filter(exchange.mutate().request(serverHttpRequest).build());
            });
        }
        return chain.filter(exchange);
    }
}
