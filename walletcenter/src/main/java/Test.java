import java.util.Arrays;

/**
 * @program: thatmall
 * @class: Test
 * @description:
 * @author: wdd
 * @create: 2022-01-26 11:02
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        System.out.println("args = " + Arrays.deepToString(args));
        for (int j = 0; j < 5; ++j) {
            System.out.println(j);
        }
    }
}
