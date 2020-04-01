//给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指由字母组成，但不包含任何空格的字符串。 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串

package com.liuzhihang.leetcode.editor.cn;
public class LengthOfLastWord{
  public static void main(String[] args) {
  
       Solution solution = new LengthOfLastWord().new Solution();

      int i = solution.lengthOfLastWord(" ");
  }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {

        if (s == null || s.trim().length() == 0) {
            return 0;
        }

        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
