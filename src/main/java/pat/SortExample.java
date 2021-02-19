package pat;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/19 11:11
 */

/**
 * 排序样例和详解：数组从小到大排序
 */
public class SortExample {
    public static void main(String[] args) {
        int[] nums = {35,18,16,72,24,65,12,88,46,28,55};
       // selectSort(nums);
        insertSort(nums);
        for(int i = 0; i <nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }


    /**
     * 选择排序：简单选择排序是指，从一个数组nums的元素num[0]~num[n-1], 令i从0到n-1枚举，进行n趟操作，每趟从待排序部分[i,n-1]中
     * 选择最小的元素，让其和待排序部分的第一个元素nums[i]进行交换，这样元素num[i]和当前有序部分[0,i-1]形成新的有序空间[0,i]。
     * 于是在n趟操作之后，所有元素就都有序了
     * 时间复杂度 O(N^2)
     * @param nums
     */
    static void selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i+1; j < n; j++) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            if (i != k) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
    }


    /**
     * 插入排序：对数组nums的n哥元素nums[0]~nums[n-1]，令i从2到n-1枚举，进行n-1趟操作，假设某一趟操作时，数组nums的前i-1哥元素
     * nums[0]~nums[i-1]已经有序，而[i, n-1]还未有序，那么该趟操作在[1, i-1]中找到一个位置j，使得nums[i]插入到位置j后(此时
     * nums[j]~nums[i-1]会后移一位nums[j+1]~nums[i]), 这是就会有[0,i]有序，最终通过n-1次操作之后整个数组就是有序的
     * @param nums
     */
    static void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0  && temp < nums[j-1]) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
    }
}
