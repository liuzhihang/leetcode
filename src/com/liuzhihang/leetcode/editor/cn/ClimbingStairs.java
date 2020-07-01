//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

package com.liuzhihang.leetcode.editor.cn;

import java.util.HashMap;

public class ClimbingStairs {
    public static void main(String[] args) {

        Solution solution = new ClimbingStairs().new Solution();


        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        int i = solution.climbStairs(9);

        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {

            if (n <= 2) {
                return n;
            }

            int[] arr = new int[n + 1];

            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;

            for (int i = 3; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}