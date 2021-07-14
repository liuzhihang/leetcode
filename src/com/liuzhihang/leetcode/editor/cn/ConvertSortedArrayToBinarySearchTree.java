//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 按 严格递增 顺序排列 
// 
// Related Topics 树 深度优先搜索 
// 👍 702 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {

        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
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
        public TreeNode sortedArrayToBST(int[] nums) {

            if (nums == null || nums.length == 0) {
                return null;
            }
            int length = nums.length;
            if (length == 1) {
                return new TreeNode(nums[0]);
            }
            if (length == 2) {

                TreeNode treeNode = new TreeNode(nums[1]);
                treeNode.left = new TreeNode(nums[0]);

                return treeNode;
            }

            int mid = length / 2;

            TreeNode midNode = new TreeNode(nums[mid]);

            int[] leftNums = new int[mid];
            System.arraycopy(nums, 0, leftNums, 0, mid);

            int[] rightNums = new int[length - mid - 1];
            System.arraycopy(nums, mid + 1, rightNums, 0, length - mid - 1);

            midNode.left = sortedArrayToBST(leftNums);
            midNode.right = sortedArrayToBST(rightNums);

            return midNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
