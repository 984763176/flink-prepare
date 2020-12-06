/**
 * Author lzc
 * Date 2020/12/1 4:22 下午
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * @Author lzc
 * @Date 2020/12/1 4:22 下午
 */
public class LambdaDemo {


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.removeIf(s -> s.length() == 4);
        list.replaceAll(x -> x.length()+"");
        System.out.println(list);

    }

}
