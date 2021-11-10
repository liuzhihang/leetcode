//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1053 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class InvertBinaryTree {

    public static void main(String[] args) {

        Solution solution = new InvertBinaryTree().new Solution();

    }

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

//leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public TreeNode invertTree(TreeNode root) {

            invert(root);

            return root;
        }


        private void invert(TreeNode node) {

            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null) {
                return;
            }

            // 交换左右
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            invert(node.left);
            invert(node.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
