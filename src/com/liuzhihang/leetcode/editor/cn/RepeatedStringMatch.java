//给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。 
//
// 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。 
//
// 
//
// 示例 1： 
//
// 输入：a = "abcd", b = "cdabcdab"
//输出：3
//解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
// 
//
// 示例 2： 
//
// 输入：a = "a", b = "aa"
//输出：2
// 
//
// 示例 3： 
//
// 输入：a = "a", b = "a"
//输出：1
// 
//
// 示例 4： 
//
// 输入：a = "abc", b = "wxyz"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length <= 10⁴ 
// 1 <= b.length <= 10⁴ 
// a 和 b 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 215 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.Arrays;

public class RepeatedStringMatch {

    public static void main(String[] args) {

        Solution solution = new RepeatedStringMatch().new Solution();

        System.out.println(solution.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
        System.out.println(Arrays.toString("ab".split("abc")));
        System.out.println("abc".startsWith(""));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int repeatedStringMatch(String a, String b) {

            if (a.contains(b)) {
                return 1;
            }

            if (a.length() > b.length()) {
                return -1;
            }

            String[] split = b.split(a);

            if (split.length == 0) {
                return b.length() / a.length();
            }

            if (split.length >= 2) {

                String s0 = split[0];
                String s1 = split[split.length - 1];

                if (a.endsWith(s0) && a.startsWith(s1)) {

                    int res = 2;

                    for (int i = 1; i < split.length - 1; i++) {

                        if (split[i].equals("")) {
                            res++;
                        } else {
                            return -1;
                        }
                    }
                    return res + 1;


                }


            }


            return -1;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
