package org.onedayday.gateway.security;

import org.onedayday.framework.utils.CollectionUtil;
import org.onedayday.framework.utils.StringUtil;
import org.onedayday.gateway.constants.HeaderConst;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: thatmall
 * @class: authorizationServerManager
 * @description:
 * @author: wdd
 * @create: 2022-02-19 11:35
 */
@Component
public class AuthorizationServerManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        // 预检请求放行
        if (request.getMethod() == HttpMethod.OPTIONS) {
            return Mono.just(new AuthorizationDecision(true));
        }
        String method = request.getMethodValue();
        String path = request.getURI().getPath();


        String token = request.getHeaders().getFirst(HeaderConst.AUTHORIZATION_HEADER);
        if (StringUtil.isNotEmpty(token) && token.startsWith(HeaderConst.JWT_PREFIX)) {

        } else {
            return Mono.just(new AuthorizationDecision(false));
        }

//
//        /**
//         * 鉴权开始
//         *
//         * 缓存取 [URL权限-角色集合] 规则数据
//         * urlPermRolesRules = [{'key':'GET:/api/v1/users/*','value':['ADMIN','TEST']},...]
//         */
//        Map<String, Object> urlPermRolesRules = redisTemplate.opsForHash().entries(GlobalConstants.URL_PERM_ROLES_KEY);

        // 根据请求路径获取有访问权限的角色列表
        List<String> authorizedRoles = new ArrayList<>();
        // 是否需要鉴权，默认未设置拦截规则不需鉴权
        boolean requireCheck = false;

//        for (Map.Entry<String, Object> permRoles : urlPermRolesRules.entrySet()) {
//            String perm = permRoles.getKey();
//            if (pathMatcher.match(perm, restfulPath)) {
//                List<String> roles = Convert.toList(String.class, permRoles.getValue());
//                authorizedRoles.addAll(Convert.toList(String.class, roles));
//                if (requireCheck == false) {
//                    requireCheck = true;
//                }
//            }
//        }
        // 没有设置拦截规则放行
        if (requireCheck == false) {
            return Mono.just(new AuthorizationDecision(true));
        }

        // 判断JWT中携带的用户角色是否有权限访问
        Mono<AuthorizationDecision> authorizationDecisionMono = mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authority -> {
                    // 用户的角色
                    String roleCode = authority.substring(0, 1);
                    // 如果是超级管理员则放行
                    if ("DD".equals(roleCode)) {
                        return true;
                    }
                    return CollectionUtil.isNotEmpty(authorizedRoles) && authorizedRoles.contains(roleCode);
                })
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
        return authorizationDecisionMono;
    }


}
