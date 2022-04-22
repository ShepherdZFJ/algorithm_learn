package LeetCode.backtrack;

import java.util.*;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/4 17:38
 */

/**
 * 题目描述：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Question17 {
    public static void main(String[] args) {
        Question17 question17 = new Question17();
        char c = 97;
        System.out.println(c);
    }
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 当index等于数字长度，说明已经遍历结束
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            // 获取输数字字符串的第index个数字
            char digit = digits.charAt(index);
            // 数字对应的字符串
            String letters = phoneMap.get(digit);
            // 数字对应字符串的长度
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                // 追加字符
                combination.append(letters.charAt(i));
                // 遍历下一个index位置数字对应字符串
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 回溯，移除前面选的字符串
                combination.deleteCharAt(index);
            }
        }
    }
}
