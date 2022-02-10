package org.onedayday.framework.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @class: BaseController
 * @description: BaseController
 * @author: wdd
 */
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    private String getHeader(String key){
        return request.getHeader(key);
    }

}
