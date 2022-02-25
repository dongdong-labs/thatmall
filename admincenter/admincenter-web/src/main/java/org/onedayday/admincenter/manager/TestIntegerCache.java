package org.onedayday.admincenter.manager;

import java.math.BigDecimal;

/**
 * @program: thatmall
 * @class: TestIntegerCache
 * @description:
 * @author: wdd
 * @create: 2022-02-19 09:09
 */
public class TestIntegerCache {
    public static void main(String[] args) {
        Integer a1 = 200;
        Integer a2 = 200;
        System.out.println(a1==a2);

        Integer a5 = 300;
        Integer a6 = 300;
        System.out.println(a5==a6);

        Long l1 = 120L;
        Long l2 = 120L;
        System.out.println(l1==l2);

        Long l3 = 127L;
        Long l4 = 127L;
        System.out.println(l3==l4);
        BigDecimal

    }
}
