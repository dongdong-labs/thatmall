package org.onedayday.framework.manager.config;


import com.alibaba.fastjson.serializer.ValueFilter;

import java.math.BigDecimal;

/**
 * @program: framework
 * @class: BigDecimalValueFilter
 * @description:
 * @author: wdd
 */

public class BigDecimalValueFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {
        if (value != null && value instanceof BigDecimal) {
            return String.format("%.2f", ((BigDecimal) value).doubleValue());
        }
        return value;
    }

    public static void main(String[] args) {
        BigDecimalValueFilter bigDecimalValueFilter = new BigDecimalValueFilter();
        BigDecimal value = BigDecimal.valueOf(10.00601);
        Object o =  bigDecimalValueFilter.process(null,"value",value);
        System.out.println(o);
    }
}