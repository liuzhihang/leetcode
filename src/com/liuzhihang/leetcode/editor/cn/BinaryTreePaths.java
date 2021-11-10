//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 597 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {

        Solution solution = new BinaryTreePaths().new Solution();

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
        public List<String> binaryTreePaths(TreeNode root) {

            LinkedList<String> pathList = new LinkedList<>();

            if (root == null) {
                return pathList;
            }
            paths(root, new StringBuilder(), pathList);

            return pathList;

        }


        private void paths(TreeNode node, StringBuilder parentPath, LinkedList<String> pathList) {

            parentPath.append(node.val);

            if (node.left == null && node.right == null) {
                pathList.add(parentPath.toString());
            }
            parentPath.append("->");
            if (node.left != null) {
                paths(node.left, new StringBuilder(parentPath), pathList);
            }
            if (node.right != null) {
                paths(node.right, new StringBuilder(parentPath), pathList);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
