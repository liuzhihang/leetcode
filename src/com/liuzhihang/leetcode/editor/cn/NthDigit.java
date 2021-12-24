//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12 ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 第 n 位上的数字是按计数单位（digit）从前往后数的第 n 个数，参见 示例 2 。 
// 
// Related Topics 数学 二分查找 👍 252 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class NthDigit {

    public static void main(String[] args) {

        Solution solution = new NthDigit().new Solution();
        System.out.println(solution.findNthDigit(15));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {

            // 先判断落在几位数中
            int numQuantity = 9;
            int length = 9;
            int digits = 1;

            int start = 1;

            while (n > length) {
                n = n - length;
                // 增加一位
                digits++;
                start = start * 10;
                numQuantity = numQuantity * 9;
                length = numQuantity * digits;
            }

            // 第 numIndex 个数就是命中的数, 起始 index 是 0
            int numIndex;
            if (n % digits == 0) {
                numIndex = n / digits - 1;
            } else {
                numIndex = n / digits;
            }

            int num = start + numIndex;

            // 倒数第几位
            int index = n % digits;
            if (index == 0) {
                return num % 10;
            } else {
                index = digits - index;
            }


            while (index != 0) {
                num = num / 10;
                index--;
            }

            return num % 10;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}
