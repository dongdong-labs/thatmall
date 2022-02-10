package org.onedayday.framework.auditlog.annotation;

import org.onedayday.framework.auditlog.enums.BehaviorEnum;

import java.lang.annotation.*;

/**
 * @author wdd
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface AuditLog {

    /**
     * 操作
     */
    BehaviorEnum behavior() default BehaviorEnum.NULL;

    /**
     * 操作对象
     */
    String object() default "";
    /**
     * 操作详情
     */
    String detail() default "";

}
