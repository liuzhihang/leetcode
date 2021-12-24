//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 570 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {

        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            // 滑动窗口

            int l1 = nums1.length;
            int l2 = nums2.length;

            int res = 0;

            // nums1 的每一节最大子串
            for (int i = 0; i < l1; i++) {
                int len = Math.min(l2, l1 - i);
                int i1 = maxLength(nums1, nums2, i, 0, len);
                res = Math.max(res, i1);
            }

            // nums2 的每一节最大子串
            for (int i = 0; i < l2; i++) {
                int len = Math.min(l1, l2 - i);
                int i1 = maxLength(nums1, nums2, 0, i, len);
                res = Math.max(res, i1);
            }

            return res;
        }

        public int maxLength(int[] nums1, int[] nums2, int st1, int st2, int len) {

            int res = 0;
            int k = 0;

            for (int i = 0; i < len; i++) {

                if (nums1[st1 + i] == nums2[st2 + i]) {
                    k++;
                } else {
                    k = 0;
                }
                res = Math.max(res, k);
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
