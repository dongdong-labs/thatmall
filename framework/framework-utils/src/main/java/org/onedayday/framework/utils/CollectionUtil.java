package org.onedayday.framework.utils;

import java.util.Collection;

/**
 * @program: thatmall
 * @class: CollectionUtil
 * @description:
 * @author: wdd
 * @create: 2022-02-25 10:37
 */
public class CollectionUtil {

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }


}
