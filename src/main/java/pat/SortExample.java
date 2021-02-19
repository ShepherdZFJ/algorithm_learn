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
       // insertSort(nums);
       // mergeSort(nums);
        quickSort(nums, 0, nums.length -1);
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


    /**
     * 归并排序：2路归并排序的原理是将序列两两分组，即分成n/2个组，组内单独排序，然后再将这些组再两两归并，生成n/4个组，组内在单独
     * 排序，以此类推，知道剩下一个组为止，即最终是一个有序的数组。归并排序的时间复杂度O(nlogn)
     * @param nums
     * @param left
     * @param right
     */
    // 递归实现归并排序算法
    static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);
            merge(nums, left, mid, mid+1, right);
        }
    }
    // 合并两个有序数组
    static void merge(int[] nums, int left1, int right1, int left2, int right2) {
        int i = left1;
        int j = left2;
        int[] result = new int[nums.length];
        int k = 0;
        while (i <= right1 && j <=right2) {
            if (nums[i] <= nums[j]) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }
        while(i <= right1) {
            result[k++] = nums[i++];
        }
        while(j <= right2) {
            result[k++] = nums[j++];
        }
        for (int x = 0; x < k; x++) {
            nums[left1+x] = result[x];
        }
    }

    //2.非递归实现算法(待研究)
    static void mergeSort(int[] nums) {
        int n = nums.length;
        for (int step = 2; step / 2 <= n; step *=2 ) {
            for (int i = 1; i <= n; i += step) {
                int mid = i + step / 2 - 1;
                if (mid + 1 <= n) {
                    merge(nums, i, mid, mid+1, Math.min(i + step - 1, n));
                }
            }
        }
    }


    /**
     * 快速排序：快速排序是排序算法中平均时间复杂度为O(nlogn)的一种算法，核心思想：对于一个序列nums[0], nums[1],.....nums[n-1],
     * 调整序列中元素的位置，使得nums[0]的左侧所有元素都小于nums[0], 右侧所有元素都大于nums[0]，这样nums[0]就到了最终位置了，接
     * 下来只需要使用递归对nums[0]左右两侧的元素进行上面的操作即可，最终形成的序列即是一个有序的数组
     * @param nums
     * @param left
     * @param right
     */
    static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    static int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

}
