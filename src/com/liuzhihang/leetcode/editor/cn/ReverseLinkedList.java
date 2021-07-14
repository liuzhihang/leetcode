//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1554 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class ReverseLinkedList {
    public static void main(String[] args) {

        Solution solution = new ReverseLinkedList().new Solution();
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

        // 递归法
        public ListNode reverseList(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode listNode = reverseList(head.next);

            head.next.next = head;
            head.next = null;
            return listNode;
        }
        // public ListNode reverseList(ListNode head) {
        //
        //     if (head == null || head.next == null) {
        //         return head;
        //     }
        //
        //     ListNode temp;
        //     ListNode newHead = null;
        //
        //     while (head != null) {
        //
        //         temp = head.next;
        //         head.next = newHead;
        //         newHead = head;
        //         head = temp;
        //
        //     }
        //
        //     return newHead;
        //
        // }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
