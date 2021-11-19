//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1410 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {

        Solution solution = new NextPermutation().new Solution();
        int[] ints = {1, 1};
        solution.nextPermutation(ints);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {

            // 从后往前遍历

            if (nums == null || nums.length == 1) {
                return;
            }

            int l = nums.length - 1;
            int r = nums.length - 1;

            while (l > 0) {

                if (nums[l - 1] >= nums[l]) {
                    l--;
                } else {
                    while (l - 1 < r) {
                        if (nums[r] <= nums[l - 1]) {
                            r--;
                        } else {
                            int temp = nums[l - 1];
                            nums[l - 1] = nums[r];
                            nums[r] = temp;
                            Arrays.sort(nums, l, nums.length);
                            return;
                        }
                    }

                }

            }

            Arrays.sort(nums);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
