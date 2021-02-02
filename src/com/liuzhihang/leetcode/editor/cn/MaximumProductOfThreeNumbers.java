//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: 6
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: 24
// 
//
// 注意: 
//
// 
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。 
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 
// 
// Related Topics 数组 数学 
// 👍 223 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {

        Solution solution = new MaximumProductOfThreeNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumProduct(int[] nums) {

            int length = nums.length;

            if (length == 3) {
                return nums[0] * nums[1] * nums[2];
            }

            // 排序
            Arrays.sort(nums);

            return Math.max(nums[length - 1] * nums[length - 2] * nums[length - 3], nums[0] * nums[1] * nums[length - 1]);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
