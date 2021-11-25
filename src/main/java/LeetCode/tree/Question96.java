package LeetCode.tree;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/25 14:42
 */

/**
 * 题目描述：给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class Question96 {
    public static void main(String[] args) {
        Question96 question96 = new Question96();
        int i = question96.numTrees(4);
        System.out.println(i);
    }


    public int numTrees(int n) {
       return  BSTCount(n);
    }


    /**
     * 解题思路：n = 1, 有一个元素,可以构成一个二叉搜索树,左右都没有元素，总数量 = 左子树数量 右子树数量，记为f(1) = f(0) f(0) = 1，这儿可以将f(0)初始化为1;
     * n = 2, 1做根，那么左子树没有元素记为f(0),右子树有一个元素记为f(1), 2做根，左子树有一个元素，记为f(1),右子树没有元素记为f(0);
     * 总共：f(2) = f(0) f(1) + f(1) f(0) = 2;
     * n = 3, 1做根，数量 = f(0) f(2), 2做根 数量 = f(1) f(1), 3做根， 数量 = f(2) f(0);
     * 总共 f(3) = f(0) f(2) + f(1) f(1) + f(2) f(0) = 5;
     * 可以看出f(n),依赖与f(0)到f(n-1),换句话说可以有前面的n-1项推导出第n项；
     * 分析关系表达式：
     * 记h(k)为以k为根可以生成的二叉搜索树数量；
     * 当以k为根时，他的左子树为[1,2 ··· k-1]构成，也就是左子树有k-1个元素构成，这个就可以记为f(k-1)；
     * 右子树为[k+1 ··· n]构成，也就是右子树有n-k个元素构成，这个可以记为f(n-k)；
     * 那么h(k) = f(k-1) * f(n-k); 要记得k的范围可以从1到n;
     * 整合以上规律可得到：有n个元素的二叉搜索树的数量；f(n) = h(1)+h(2)+···+h(n) = ∑ h(k) ,0 < k <= n;
     * 又因为h(k) = f(k-1) f(n-k)得到：f(n) = ∑ f(k-1) f(n-k); 0 < k <= n;
     * @param n
     * @return
     */
    int BSTCount(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        //遍历1到n，分别以1到n做根节点情况
        for(int i = 1; i <= n; i++) {
            //求得以i为根节点，二叉搜索树的数量 eg：res[3]=res[0]*res[2]+res[1]*res[1]+res[2]*res[0]
            for(int k = 1; k <= i; k++) {
                res[i] += res[k-1] * res[i-k];
            }
        }
        return res[res.length-1];
    }
}
