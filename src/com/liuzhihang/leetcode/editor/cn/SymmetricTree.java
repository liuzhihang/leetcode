//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索


package com.liuzhihang.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {

        Solution solution = new SymmetricTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        // 迭代
        public boolean isSymmetric(TreeNode root) {

            if (root == null) {
                return true;
            }

            TreeNode left = root.left;
            TreeNode right = root.right;

            Queue<TreeNode> treeNodeQueue = new LinkedList<>();

            treeNodeQueue.offer(left);
            treeNodeQueue.offer(right);

            while (!treeNodeQueue.isEmpty()) {
                // 连续吐出两次分别是左右的
                left = treeNodeQueue.poll();
                right = treeNodeQueue.poll();

                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }

                if (left.val != right.val) {
                    return false;
                }

                treeNodeQueue.offer(left.left);
                treeNodeQueue.offer(right.right);

                treeNodeQueue.offer(left.right);
                treeNodeQueue.offer(right.left);

            }

            return true;
        }




    }


    // 递归法
    // public boolean isSymmetric(TreeNode root) {
    //
    //     if (root == null) {
    //         return true;
    //     }
    //
    //     return isEq(root.left, root.right);
    // }
    //
    // public boolean isEq(TreeNode left, TreeNode right) {
    //
    //     if (left == null && right == null) {
    //         return true;
    //     }
    //
    //     if (left != null && right != null) {
    //         if (left.val == right.val) {
    //             return isEq(left.left, right.right) && isEq(left.right, right.left);
    //         }
    //
    //     }
    //
    //     return false;
    // }





//
//leetcode submit region end(Prohibit modification and deletion)

}
