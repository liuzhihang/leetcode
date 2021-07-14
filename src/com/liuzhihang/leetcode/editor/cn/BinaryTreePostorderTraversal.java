//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 532 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {

        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        // 后序遍历 左 右 根
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> integerList = new LinkedList<>();

            //


            return integerList;
        }


        // // 后序遍历 左 右 根
        // public List<Integer> postorderTraversal(TreeNode root) {
        //         List<Integer> integerList = new LinkedList<>();
        //
        //     postorderTraversal(root, integerList);
        //
        //         return integerList;
        // }
        // public void postorderTraversal (TreeNode root, List<Integer> integerList) {
        //
        //     if (root == null) {
        //         return;
        //     }
        //     postorderTraversal(root.left, integerList);
        //     postorderTraversal(root.right, integerList);
        //     integerList.add(root.val);
        // }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
