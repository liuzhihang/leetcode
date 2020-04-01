//报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下： 
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 被读作 "one 1" ("一个一") , 即 11。 
//11 被读作 "two 1s" ("两个一"）, 即 21。 
//21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。 
//
// 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。 
//
// 注意：整数顺序将表示为一个字符串。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "1"
// 
//
// 示例 2: 
//
// 输入: 4
//输出: "1211"
// 
// Related Topics 字符串

package com.liuzhihang.leetcode.editor.cn;

import java.net.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountAndSay {
    public static void main(String[] args) throws UnknownHostException {

        // Solution solution = new CountAndSay().new Solution();
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println("hostAddress = " + hostAddress);
    }



    static class A1{
        private String test;
    }
    static class A2{
        private String test;
    }


    /**
     * 每次输入数的时候将之前的重新遍历一遍
     *
     * 也考虑使用队列
     */


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {


            String result = "1";

            if (n == 1) {
                return result;
            }

            int x = 1;
            while (x != n) {
                x++;

                char[] chars = result.toCharArray();

                char cTmp = chars[0];
                int cTmpCount = 0;

                String tmpResult = "";

                for (int i = 0; i < chars.length; i++) {
                    char aChar = chars[i];
                    if (cTmp == aChar) {
                        cTmpCount++;
                    } else {
                        tmpResult = tmpResult + cTmpCount + chars[i - 1];
                        cTmpCount = 1;
                        cTmp = aChar;
                    }
                    if (i == chars.length - 1) {
                        tmpResult = tmpResult + cTmpCount + aChar;
                    }

                }
                result = tmpResult;
                System.out.println(result);
            }


            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
