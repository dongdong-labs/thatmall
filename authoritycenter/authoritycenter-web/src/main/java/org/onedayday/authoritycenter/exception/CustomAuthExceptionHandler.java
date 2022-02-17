package org.onedayday.authoritycenter.exception;

import lombok.extern.slf4j.Slf4j;
import org.onedayday.framework.result.Result;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: thatmall
 * @class: CustomAuthExceptionHandler
 * @description:
 * @author: wdd
 * @create: 2022-02-15 12:02
 */
@RestControllerAdvice
@Slf4j
public class CustomAuthExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = OAuth2Exception.class)
    public Result handleOauth2(OAuth2Exception e) {
        return Result.fail(e.getMessage());
    }
}
