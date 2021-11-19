//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 3983 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        Solution solution = new ThreeSum().new Solution();

        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        System.out.println("lists = " + lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            int length = nums.length;

            if (length < 3) {
                return new ArrayList<>();
            }

            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i < length - 2; i++) {

                int cur = nums[i];
                if (cur > 0) {
                    break;
                }

                if (i > 0 && nums[i - 1] == cur) {
                    continue;
                }


                int li = i + 1;
                int ri = length - 1;

                while (li < ri) {
                    int numLi = nums[li];
                    int numRi = nums[ri];
                    int sum = cur + numLi + numRi;
                    if (sum == 0) {
                        res.add(Arrays.asList(cur, numLi, numRi));

                        // 移除相等的数据
                        li++;
                        ri--;
                        while (nums[li] == numLi && li < ri) {
                            li++;
                        }
                        while (nums[ri] == numLi && li < ri) {
                            ri--;
                        }

                    } else if (sum > 0) {
                        ri--;
                    } else {
                        li++;
                    }
                }

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
