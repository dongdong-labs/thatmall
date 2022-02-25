package org.onedayday.framework.utils;

/**
 * @program: thatmall
 * @class: StringUtil
 * @description:
 * @author: wdd
 * @create: 2022-02-25 09:11
 */
public class StringUtil {

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence str) {
        return isEmpty(str) ? false : true;
    }
}
