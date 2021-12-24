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

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        // 递归法
        public ListNode reverseList(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode tempHead = null;


            while (head != null) {
                ListNode temp = head.next;
                head.next = tempHead;
                tempHead = head;
                head = temp;
            }

            return tempHead;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
