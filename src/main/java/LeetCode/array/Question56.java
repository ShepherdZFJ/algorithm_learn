package LeetCode.array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2024/3/14 18:51
 */
public class Question56 {
    public static void main(String[] args) {
        Question56 question56 = new Question56();
        int[][] intervals = {{2,6},{1,3},{7,18},{8,13}};
        question56.merge(intervals);
        System.out.println(intervals);
    }


    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        for ( int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                int s1 = intervals[j][0];
                int s2 = intervals[j + 1][0];
                if (s1 > s2) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j+1];
                    intervals[j+1]=temp;
                }
            }
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0];
            if (s > end) {
                map.put(start, end);
                start = s;
            }
            end = intervals[i][1] > end ? intervals[i][1] : end;
        }
        map.put(start, end);
        int[][] ans = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer s = entry.getKey();
            Integer e = entry.getValue();
            ans[i] = new int[]{s, e};
            i++;
        }
        return ans;
    }
}
