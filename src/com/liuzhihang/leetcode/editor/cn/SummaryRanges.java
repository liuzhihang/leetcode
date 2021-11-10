//给定一个无重复元素的有序整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 示例 3： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：["-1"]
// 
//
// 示例 5： 
//
// 
//输入：nums = [0]
//输出：["0"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
// Related Topics 数组 👍 179 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {

        Solution solution = new SummaryRanges().new Solution();
        List<String> strings = solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});

        System.out.println("strings = " + strings);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {

            List<String> result = new LinkedList<>();

            if (nums == null || nums.length == 0) {
                return result;
            }

            int before = nums[0];
            int start = nums[0];
            int startIndex = 0;
            for (int i = 1; i < nums.length; i++) {

                int current = nums[i];

                if (current - before == 1) {
                    before = current;
                    continue;
                }

                // 不等于
                if (startIndex + 1 == i) {
                    result.add(start + "");
                } else {
                    result.add(start + "->" + before);
                }
                before = current;
                start = current;
                startIndex = i;

            }

            // 不等于
            if (startIndex + 1 == nums.length) {
                result.add(start + "");
            } else {
                result.add(start + "->" + nums[nums.length - 1]);
            }

            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
