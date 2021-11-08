//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。 
//
// 
//
// 例如， 
//
// 
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 示例 4: 
//
// 
//输入: columnTitle = "FXSHRXW"
//输出: 2147483647
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
// Related Topics 数学 字符串 👍 291 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {

        Solution solution = new ExcelSheetColumnNumber().new Solution();

        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("AB"));
        System.out.println(solution.titleToNumber("ZY"));
        System.out.println(solution.titleToNumber("FXSHRXW"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {

            if (columnTitle == null || columnTitle.trim().length() == 0) {
                return 0;
            }

            // 相当于 26 进制, A = 65
            char[] chars = columnTitle.toCharArray();
            int length = chars.length;

            int result = 0;

            for (int i = length - 1; i >= 0; i--) {

                int num = convert(chars[i]);
                // 是倒数第几位, 从 0 开始
                int index = length - i - 1;

                int pow = (int) Math.pow(26, index);

                result = result + num * pow;

            }


            return result;
        }

        private int convert(char c) {
            return c - 'A' + 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
