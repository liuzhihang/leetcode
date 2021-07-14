//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 789 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> listList = new LinkedList<>();

            if (root == null) {
                return listList;
            }

            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();
            queue1.offer(root);

            List<Integer> list = new LinkedList<>();

            boolean queue1Flag = true;

            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                if (queue1Flag) {
                    TreeNode poll = queue1.poll();

                    list.add(poll.val);

                    if (poll.left != null) {
                        queue2.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue2.offer(poll.right);
                    }

                    if (queue1.isEmpty()) {
                        listList.add(list);
                        list = new LinkedList<>();
                        queue1Flag = false;
                    }

                } else {
                    TreeNode poll = queue2.poll();

                    list.add(poll.val);

                    if (poll.left != null) {
                        queue1.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue1.offer(poll.right);
                    }

                    if (queue2.isEmpty()) {
                        listList.add(list);
                        list = new LinkedList<>();
                        queue1Flag = true;
                    }
                }
            }
            return listList;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
