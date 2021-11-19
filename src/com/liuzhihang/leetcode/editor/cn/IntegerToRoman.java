//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + 
//II 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给你一个整数，将其转为罗马数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 3
//输出: "III" 
//
// 示例 2: 
//
// 
//输入: num = 4
//输出: "IV" 
//
// 示例 3: 
//
// 
//输入: num = 9
//输出: "IX" 
//
// 示例 4: 
//
// 
//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: num = 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 3999 
// 
// Related Topics 哈希表 数学 字符串 👍 725 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.HashMap;

public class IntegerToRoman {

    public static void main(String[] args) {

        Solution solution = new IntegerToRoman().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String intToRoman(int num) {

            HashMap<String, String> relationMap = new HashMap<>();

            relationMap.put("thousand1", "M");
            relationMap.put("thousand2", "MM");
            relationMap.put("thousand3", "MMM");
            relationMap.put("hundred1", "C");
            relationMap.put("hundred2", "CC");
            relationMap.put("hundred3", "CCC");
            relationMap.put("hundred4", "CD");
            relationMap.put("hundred5", "D");
            relationMap.put("hundred6", "DC");
            relationMap.put("hundred7", "DCC");
            relationMap.put("hundred8", "DCCC");
            relationMap.put("hundred9", "CM");
            relationMap.put("ten1", "X");
            relationMap.put("ten2", "XX");
            relationMap.put("ten3", "XXX");
            relationMap.put("ten4", "XL");
            relationMap.put("ten5", "L");
            relationMap.put("ten6", "LX");
            relationMap.put("ten7", "LXX");
            relationMap.put("ten8", "LXXX");
            relationMap.put("ten9", "XC");
            relationMap.put("a1", "I");
            relationMap.put("a2", "II");
            relationMap.put("a3", "III");
            relationMap.put("a4", "IV");
            relationMap.put("a5", "V");
            relationMap.put("a6", "VI");
            relationMap.put("a7", "VII");
            relationMap.put("a8", "VIII");
            relationMap.put("a9", "IX");


            String s = "";

            int thousand = num / 1000;
            if (thousand > 0) {
                s = s + relationMap.get("thousand" + thousand);
            }

            int hundred = (num % 1000) / 100;

            if (hundred > 0) {
                s = s + relationMap.get("hundred" + hundred);
            }

            int ten = (num % 100) / 10;

            if (ten > 0) {
                s = s + relationMap.get("ten" + ten);
            }

            int a = num % 10;
            if (a > 0) {
                s = s + relationMap.get("a" + a);
            }

            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
