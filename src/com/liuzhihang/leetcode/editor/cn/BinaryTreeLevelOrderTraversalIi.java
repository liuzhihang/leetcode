//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 398 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi {


    public static void main(String[] args) {

        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> listList = new LinkedList<>();

            if (root == null) {
                return listList;
            }


            Queue<TreeNode> one = new LinkedList<>();
            Queue<TreeNode> two = new LinkedList<>();
            one.offer(root);

            List<Integer> nodeList = new ArrayList<>();

            boolean oneFlag = true;

            while (!one.isEmpty() || !two.isEmpty()) {
                if (oneFlag) {
                    TreeNode node = one.poll();
                    nodeList.add(node.val);

                    if (node.left != null) {
                        two.offer(node.left);
                    }

                    if (node.right != null) {
                        two.offer(node.right);
                    }

                    if (one.isEmpty()) {
                        listList.addFirst(nodeList);
                        nodeList = new ArrayList<>();
                        oneFlag = false;
                    }

                } else {
                    TreeNode node = two.poll();
                    nodeList.add(node.val);

                    if (node.left != null) {
                        one.offer(node.left);
                    }
                    if (node.right != null) {
                        one.offer(node.right);
                    }

                    if (two.isEmpty()) {
                        listList.addFirst(nodeList);
                        nodeList = new ArrayList<>();
                        oneFlag = true;
                    }

                }

            }

            return listList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
