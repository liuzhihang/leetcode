//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1167 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class PalindromeLinkedList {

    public static void main(String[] args) {

        Solution solution = new PalindromeLinkedList().new Solution();


        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        solution.isPalindrome(listNode1);


    }

    public static class ListNode {
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
        public boolean isPalindrome(ListNode head) {

            // 反转一半的链表 + 快慢指针

            if (head == null || head.next == null) {
                return true;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            ListNode reverseHalfHead = new ListNode();

            while (fast != null && fast.next != null) {

                ListNode slowNext = slow.next;

                slow.next = reverseHalfHead.next;
                reverseHalfHead.next = slow;
                slow = slowNext;
                fast = fast.next.next;
            }


            if (fast != null) {

                // 执行到这里 slow 指向的是第二段的开头
                ListNode slowNext = slow.next;
                if (slow.val != slowNext.val) {
                    return false;
                }
                slow = slowNext.next;
            } else {
                slow = slow.next;
            }

            ListNode reverseHalf = reverseHalfHead.next;

            while (reverseHalf != null && slow != null) {

                if (reverseHalf.val != slow.val) {
                    return false;
                }
                reverseHalf = reverseHalf.next;
                slow = slow.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
