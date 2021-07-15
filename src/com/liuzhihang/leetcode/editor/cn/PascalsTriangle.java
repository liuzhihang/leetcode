//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 动态规划 
// 👍 527 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {

        Solution solution = new PascalsTriangle().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> generate(int numRows) {

            List<List<Integer>> result = new ArrayList<>(numRows);

            if (numRows == 0) {
                return result;
            }


            ArrayList<Integer> currentLine = new ArrayList<>();

            for (int i = 1; i <= numRows; i++) {
                ArrayList<Integer> iLine = nextLine(currentLine);
                result.add(iLine);
                currentLine = iLine;
            }

            return result;
        }

        /**
         * nextLine 的 n 位等于 current 的 n -1位 + n位
         *
         * @param currentLine
         * @return
         */
        private ArrayList<Integer> nextLine(ArrayList<Integer> currentLine) {

            int currentSize = currentLine.size();

            ArrayList<Integer> nextLine = new ArrayList<>(currentSize + 1);
            nextLine.add(1);

            if (currentLine.isEmpty()) {
                return nextLine;
            }


            for (int i = 1; i < currentSize; i++) {
                nextLine.add(currentLine.get(i - 1) + currentLine.get(i));
            }

            nextLine.add(1);

            return nextLine;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
