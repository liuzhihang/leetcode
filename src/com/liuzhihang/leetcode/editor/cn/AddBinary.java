//给定两个二进制字符串，返回他们的和（用二进制表示）。 
//
// 输入为非空字符串且只包含数字 1 和 0。 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
// Related Topics 数学 字符串



package com.liuzhihang.leetcode.editor.cn;

public class AddBinary {
    public static void main(String[] args) throws Exception {

        Solution solution = new AddBinary().new Solution();

        System.out.println(solution.addBinary("1", "111"));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            // 默认a长度大于b
            int al = a.length();
            int bl = b.length();

            if (al < bl) {
                // 交换
                String tempStr = a;
                a = b;
                b = tempStr;

                int tempInt = al;
                al = bl;
                bl = tempInt;
            }

            int gap = al - bl;

            int comeInto = 0;

            StringBuilder res = new StringBuilder();

            for (int i = al - 1; i >= 0; i--) {


                int charAtA = a.charAt(i) - '0';
                int charAtB = i - gap >= 0 ? b.charAt(i - gap) - '0' : 0;

                // 结果 异或 相同为 0 不同为1
                int i1 = charAtA ^ charAtB ^ comeInto;
                // 是否进制
                comeInto = charAtA + charAtB + comeInto > 1 ? 1 : 0;

                res.insert(0, i1);

            }

            if (comeInto == 1) {
                res.insert(0, '1');
            }

            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
