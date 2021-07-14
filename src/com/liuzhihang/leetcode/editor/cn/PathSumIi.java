//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 430 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {

        Solution solution = new PathSumIi().new Solution();
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
        List<List<Integer>> listList = new LinkedList<>();

        LinkedList<Integer> list = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {


            pathSumT(root, targetSum);
            return listList;
        }

        private void pathSumT(TreeNode root, int targetSum) {

            if (root == null) {
                return;
            }

            list.add(root.val);

            int targetSumTemp = targetSum - root.val;

            if (targetSumTemp == 0 && root.left == null && root.right == null) {
                listList.add(new LinkedList<>(list));

            }

            pathSumT(root.left, targetSumTemp);
            pathSumT(root.right, targetSumTemp);
            list.removeLast();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
