//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 703 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class ReverseLinkedListIi {
    public static void main(String[] args) {

        Solution solution = new ReverseLinkedListIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            if (left == right) {
                return head;
            }

            // 第一个节点位置是
            ListNode tempHead = new ListNode(-1, head);

            ListNode prevNode = tempHead;

            // 上一个节点, 节点从 1 开始计数
            for (int i = 1; i < left; i++) {
                prevNode = prevNode.next;
            }

            ListNode cur = prevNode.next;
            // left 位置的节点
            ListNode leftNode = prevNode.next;
            ListNode temp;

            // 反转
            for (int i = left; i < right; i++) {
                leftNode.next = cur.next;
                temp = cur.next;

                cur.next = prevNode.next;
                prevNode.next = cur;
                cur = temp;

            }
            return tempHead.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
