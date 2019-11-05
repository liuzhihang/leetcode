//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找

package com.liuzhihang.leetcode.editor.cn;

public class SearchInsertPosition {
    public static void main(String[] args) {

        Solution solution = new SearchInsertPosition().new Solution();

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {

            if (nums.length == 0) {
                return 0;
            }

            int low = 0;
            int high = nums.length;

            while (high - low > 1) {

                int middle = (low + high) / 2;

                int val = nums[middle];

                if (val == target) {
                    return middle;
                } else if (val > target) {
                    high = middle;
                } else {
                    low = middle;
                }
            }
            if (nums[low] > target) {
                return low == 0 ? 0 : low - 1;
            } else if (nums[low] < target) {
                return low + 1;
            } else {
                return low;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
