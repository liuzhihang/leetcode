//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package com.liuzhihang.leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        Solution solution = new LongestCommonPrefix().new Solution();

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            if (strs.length == 0) {
                return "";
            }

            String str0 = strs[0];

            for (int i = 1; i < strs.length; i++) {
                while (!strs[i].startsWith(str0)) {
                    str0 = str0.substring(0, str0.length() - 1);
                }

            }


            return str0;

            // if (strs.length == 1) {
            //     return strs[0];
            // }
            // String str0 = strs[0];
            //
            //
            // char[] chars0 = str0.toCharArray();
            //
            // StringBuilder r = new StringBuilder();
            //
            // for (int i = 0; i < chars0.length; i++) {
            //     char c = chars0[i];
            //
            //     for (int j = 1; j < strs.length; j++) {
            //         String str = strs[j];
            //         char[] chars = str.toCharArray();
            //         if (i == chars.length) {
            //             return r.toString();
            //         }
            //         if (chars[i] != c) {
            //             return r.toString();
            //         }
            //
            //     }
            //     r.append(c);
            // }
            //
            // return r.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
