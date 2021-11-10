//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 字符串 👍 401 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.HashMap;

public class IsomorphicStrings {

    public static void main(String[] args) {

        Solution solution = new IsomorphicStrings().new Solution();
        boolean isomorphic = solution.isIsomorphic("aaa", "bbb");

        System.out.println("isomorphic = " + isomorphic);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {

            if (s.length() != t.length()) {
                return false;
            }

            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            HashMap<Character, Character> relateMap1 = new HashMap<>(s.length());
            HashMap<Character, Character> relateMap2 = new HashMap<>(s.length());

            for (int i = 0; i < s.length(); i++) {

                char sc = sChars[i];
                char tc = tChars[i];

                // 互为映射
                Character character1 = relateMap1.get(sc);
                Character character2 = relateMap2.get(tc);

                if (character1 == null && character2 == null) {
                    relateMap1.put(sc, tc);
                    relateMap2.put(tc, sc);
                    continue;
                }

                if (character1 == null || character2 == null) {
                    return false;
                }

                if (character1 == tc && character2 == sc) {
                    continue;
                }

                return false;

            }

            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
