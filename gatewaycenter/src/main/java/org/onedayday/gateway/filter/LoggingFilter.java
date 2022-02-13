package org.onedayday.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @program: gateway
 * @class: LoggingFilter
 * @description:
 * @author: wdd
 * @create: 2021-10-03 09:32
 */
@Slf4j
@Component
public class LoggingFilter  implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String info = String.format("Method:{%s} Host:{%s} Path:{%s} Query:{%s}",
                exchange.getRequest().getMethod().name(),
                exchange.getRequest().getURI().getHost(),
                exchange.getRequest().getURI().getPath(),
                exchange.getRequest().getQueryParams());
        log.info(info);
        exchange.getAttributes().put("START_TIME", System.currentTimeMillis());
        return  chain.filter(exchange).then( Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute("START_TIME");
            if(startTime!= null){
                Long executeTime = (System.currentTimeMillis() - startTime);
                log.info(exchange.getRequest().getURI().getRawPath() +":" + executeTime +"ms");
            }
        }));
    }

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
