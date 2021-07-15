//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 动态规划 
// 👍 304 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {

    public static void main(String[] args) {

        Solution solution = new PascalsTriangleIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> getRow(int rowIndex) {

            // rowIndex >= 0  rowIndex 是 0 相当于第一行
            ArrayList<Integer> currentLine = new ArrayList<>(1);
            currentLine.add(1);

            if (rowIndex == 0) {
                return currentLine;
            }

            for (int i = 1; i <= rowIndex; i++) {

                ArrayList<Integer> nextLine = new ArrayList<>(i);
                nextLine.add(1);

                for (int j = 1; j < currentLine.size(); j++) {
                    nextLine.add(currentLine.get(j - 1) + currentLine.get(j));
                }
                nextLine.add(1);
                currentLine = nextLine;
            }

            return currentLine;

        }


    }


//leetcode submit region end(Prohibit modification and deletion)


}
