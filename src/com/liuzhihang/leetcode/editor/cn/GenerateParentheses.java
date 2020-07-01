//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


package com.liuzhihang.leetcode.editor.cn;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {

        Solution solution = new GenerateParentheses().new Solution();

        List<String> stringList = solution.generateParenthesis(3);

        System.out.println(stringList);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> generateParenthesis(int n) {

            List<String> resultList = new ArrayList<>();
            generate(n, n, "", resultList);
            return resultList;
        }


        private void generate(int left, int right, String result, List<String> resultList) {


            if (right == 0) {
                resultList.add(result);
                return;
            }

            if (left == right) {
                generate(--left, right, result + "(", resultList);
            } else {

                int right1 = right;
                generate(left, --right1, result + ")", resultList);

                if (left > 0) {
                    int left1 = left;
                    generate(--left1, right, result + "(", resultList);
                }

            }


        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
