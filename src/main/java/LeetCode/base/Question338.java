package LeetCode.base;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/11 10:53
 */
public class Question338 {
    public static void main(String[] args) {
        Question338 question338 = new Question338();
        int[] ints = question338.countBits(5);
        System.out.println(ints);

    }
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i] = count(i);
        }
        return res;
    }

    public int count(int n) {
        int c = 0;
        while(n != 0) {
            if ((n%2) == 1) {
                c++;
            }
            n = n/2;
        }
        return c;
    }


}
