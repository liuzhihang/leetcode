//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package com.liuzhihang.leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

        Solution solution = new ValidParentheses().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {


            Stack<Character> stack = new Stack<>();

            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];


                if (stack.empty()) {
                    stack.push(aChar);
                } else {
                    Character peek = stack.peek();
                    if (peek == '(' && aChar == ')') {
                        stack.pop();
                    } else if (peek == '{' && aChar == '}') {
                        stack.pop();
                    } else if (peek == '[' && aChar == ']') {
                        stack.pop();
                    } else {
                        stack.push(aChar);
                    }
                }

            }

            return stack.empty();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
