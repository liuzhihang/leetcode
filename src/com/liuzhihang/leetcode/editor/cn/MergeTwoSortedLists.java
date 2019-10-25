//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package com.liuzhihang.leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

        Solution solution = new MergeTwoSortedLists().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode hardNode = new ListNode(0);

            ListNode curNode = hardNode;

            while (l1 != null && l2 != null) {

                if (l1.val < l2.val) {
                    curNode.next = l1;
                    l1 = l1.next;
                } else {
                    curNode.next = l2;
                    l2 = l2.next;
                }
                curNode = curNode.next;
            }

            if (l1 == null) {
                curNode.next = l2;
            } else {
                curNode.next = l1;
            }

            return hardNode.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
