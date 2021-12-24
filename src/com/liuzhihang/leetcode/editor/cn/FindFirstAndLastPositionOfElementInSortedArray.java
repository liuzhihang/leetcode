//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1304 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {

        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();

        int[] ints = solution.searchRange(new int[]{2, 2}, 2);

        System.out.println("ints = " + Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            int i = searchIndex(nums, target);

            if (i == -1) {
                return new int[]{-1, -1};
            }

            int l = i;
            int r = i;

            while (l > 0) {
                if (nums[l - 1] != target) {
                    break;
                }
                l--;
            }

            while (r < nums.length - 1) {
                if (nums[r + 1] != target) {
                    break;
                }
                r++;

            }

            return new int[]{l, r};


        }

        public int searchIndex(int[] nums, int target) {

            int l = 0;
            int r = nums.length - 1;

            while (l <= r) {

                int m = l + ((r - l) >> 1);

                if (nums[m] == target) {
                    return m;
                }

                if (nums[m] > target) {
                    r = m - 1;
                }

                if (nums[m] < target) {
                    l = m + 1;
                }

            }

            return -1;


        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
