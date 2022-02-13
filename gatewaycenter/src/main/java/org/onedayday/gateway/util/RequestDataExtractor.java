package org.onedayday.gateway.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.function.Consumer;

/**
 * @program: report
 * @class: RequestDataExtractor
 * @description:
 * @author: wdd
 * @create: 2020-10-01 14:53
 */
public class RequestDataExtractor {
    /**
     * 获取请求头
     */
    public static String getHeader(ServerHttpRequest request, String key) {
        List<String> list = request.getHeaders().get(key);
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 获得访问路径
     */
    public static String getPath(ServerHttpRequest request) {
        return request.getURI().getPath();
    }

    /**
     * 添加请求头
     */
    public static void addHeader(ServerWebExchange exchange, Consumer<HttpHeaders> httpHeaders) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest serverHttpRequest = request.mutate().headers(httpHeaders).build();
        exchange.mutate().request(serverHttpRequest).build();
    }

    /**
     * 获取远程主机的真实ip
     */
    public static String getIpAddress(ServerHttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        String ip = headers.getFirst("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.contains(",")) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = headers.getFirst("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = headers.getFirst("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = headers.getFirst("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = headers.getFirst("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = headers.getFirst("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddress().getAddress().getHostAddress();
        }
        return ip;
    }

}
