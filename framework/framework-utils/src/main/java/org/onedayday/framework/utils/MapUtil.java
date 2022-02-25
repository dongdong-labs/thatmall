package org.onedayday.framework.utils;

import java.util.Map;

/**
 * @program: thatmall
 * @class: MapUtil
 * @description:
 * @author: wdd
 * @create: 2022-02-25 10:40
 */
public class MapUtil {
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return null != map && !map.isEmpty();
    }

}
