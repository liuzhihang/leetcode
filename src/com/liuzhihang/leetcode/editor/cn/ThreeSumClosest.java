//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 双指针 排序 👍 947 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {

        Solution solution = new ThreeSumClosest().new Solution();

        int i = solution.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1);

        // -2
        System.out.println("i = " + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {

            Arrays.sort(nums);

            int length = nums.length;

            int best = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < length - 2; i++) {

                int cur = nums[i];

                if (i > 0 && nums[i - 1] == cur) {
                    continue;
                }

                int l = i + 1;
                int r = length - 1;

                while (l < r) {

                    int numLi = nums[l];
                    int numRi = nums[r];

                    int sum = cur + numLi + numRi;

                    if (sum == target) {
                        return target;
                    }

                    if (Math.abs(sum - target) < Math.abs(best - target)) {
                        best = sum;
                    }
                    if (sum > target) {
                        int r0 = r - 1;
                        while (l < r0 && nums[r0] == nums[r]) {
                            --r0;
                        }
                        r = r0;
                    } else {
                        // 如果和小于 target，移动 b 对应的指针
                        int l0 = l + 1;
                        // 移动到下一个不相等的元素
                        while (l0 < r && nums[l0] == nums[l]) {
                            ++l0;
                        }
                        l = l0;
                    }


                }
            }

            return best;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
