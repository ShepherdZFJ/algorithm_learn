package LeetCode;

import java.util.*;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/18 20:49
 */
public class Question30 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] word = {"word","good","best"};
        List<Integer> list = findSubstring(s, word);
        System.out.println(list);
    }


    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s.length() > 0 && words.length > 0) {
            List<String> wordList = Arrays.asList(words);
            Map<String, Integer> map = new HashMap<>();
            int wordLength = 0;
            for(String str : wordList) {
                wordLength += str.length();
                if (map.containsKey(str)) {
                    map.put(str, map.get(str)+1);
                } else {
                    map.put(str, 1);
                }
            }
            for(int i = 0; i < s.length(); i++) {
                String str = null;
                if ((i+wordLength)>s.length() ) {
                    str = s.substring(i);
                } else {
                    str = s.substring(i, wordLength+i);
                }
                boolean flag = false;
                for (String string : wordList) {
                    if (!str.contains(string)) {
                        flag = true;
                        break;
                    }
                    if (map.get(string) > 1) {
                        int count = 0;
                        int index = str.indexOf(string); //第一个出现的位置
                        while (index != -1) {
                            count++;
                            index = str.indexOf(string, index + 1);
                        }
                        if (!(map.get(string) == count)) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    list.add(i);
                }
            }
        }
        return list;

    }
}
