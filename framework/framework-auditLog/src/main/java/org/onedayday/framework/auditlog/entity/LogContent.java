package org.onedayday.framework.auditlog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: framework
 * @class: LogContent
 * @description:
 * @author: wdd
 * @create: 2022-02-08 17:28
 */
@Data
public class LogContent {

    /**
     * 项目名称
     **/
    private String applicationName;

    /**
     * 类名
     **/
    private String className;

    /**
     * 方法名
     **/
    private String methodName;

    /**
     * 参数
     **/
    private String args;

    /**
     * 对象
     **/
    private String object;

    /**
     * 行为
     **/
    private String behavior;

    /**
     * 操作详情
     **/
    private String detail;

    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 操作人名称
     **/
    private String userName;

    /**
     * 操作时间
     */
    private Date operatorTime;

}
