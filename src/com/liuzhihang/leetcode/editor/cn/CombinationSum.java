//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 1631 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        Solution solution = new CombinationSum().new Solution();

        List<List<Integer>> lists = solution.combinationSum(new int[]{3, 5, 8}, 11);

        System.out.println("lists = " + lists);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            Arrays.sort(candidates);
            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i < candidates.length; i++) {
                combinationSum(res, new ArrayList<>(), candidates, i, target);
            }

            return res;
        }

        public void combinationSum(List<List<Integer>> lists, List<Integer> list, int[] candidates, int l, int target) {

            if (l >= candidates.length) {
                return;
            }


            if (candidates[l] > target) {
                return;
            }

            if (candidates[l] == target) {
                list.add(candidates[l]);
                lists.add(list);
                return;
            }


            List<Integer> temp1 = new ArrayList<>(list);
            temp1.add(candidates[l]);
            combinationSum(lists, temp1, candidates, l, target - candidates[l]);

            // 剩余的数中有直接满足条件的
            for (int i = l + 1; i < candidates.length; i++) {
                if (target == candidates[i]) {
                    list.add(candidates[i]);
                    lists.add(list);
                    return;
                }
            }

            List<Integer> temp2 = new ArrayList<>(list);
            temp2.add(candidates[l]);
            combinationSum(lists, temp2, candidates, l + 1, target - candidates[l]);

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
