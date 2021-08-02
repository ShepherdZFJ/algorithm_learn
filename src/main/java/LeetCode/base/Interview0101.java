package LeetCode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/8/2 14:11
 */
public class Interview0101 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(isUnique(s));
    }
    public static boolean isUnique(String astr) {
        if (astr== null || astr=="") {
            return false;
        }
        char[] chars = astr.toCharArray();
        Map<Character, Boolean> map = new HashMap<>();
        for (int i=0; i< chars.length; i++) {
            if (map.get(chars[i]) != null && map.get(chars[i])) {
                return false;
            }
            map.put(chars[i], true);
        }
        return true;
    }
}
