//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1006 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {

        Solution solution = new FourSum().new Solution();

        System.out.println(solution.fourSum(new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000}, -1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            List<List<Integer>> res = new ArrayList<>();

            int len = nums.length;
            if (len < 4) {
                return res;
            }

            Arrays.sort(nums);

            for (int i = 0; i < len - 3; i++) {

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }

                if ((long) nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                    continue;
                }

                for (int j = i + 1; j < len - 2; j++) {

                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }

                    if ((long) nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                        continue;
                    }

                    int l = j + 1;
                    int r = len - 1;

                    while (l < r) {

                        long sum = nums[i] + nums[j] + nums[l] + nums[r];

                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            l++;
                            while (l < r && nums[r] == nums[r - 1]) {
                                r--;
                            }
                            r--;
                        } else if (sum < target) {
                            l++;
                        } else {
                            r--;
                        }

                    }
                }

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
