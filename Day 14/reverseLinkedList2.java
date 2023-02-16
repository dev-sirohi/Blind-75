/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        if (right == left) return head;

        ListNode ptr = head;
        int count = left;
        while (--count > 1) {
            ptr = ptr.next;
        }

        System.out.println(ptr.val);

        ListNode end, start;

        if (left == 1) {
            start = new ListNode(0, head);
            end = head;
        } else {
            end = ptr.next;
            start = ptr;
        }
        
        if (left != 1) ptr = ptr.next;
        ListNode prev = new ListNode(0, ptr);

        count = 0;
        while (ptr != null && count != right - left + 1) {
            ListNode next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
            count++;
        }

        end.next = ptr;
        start.next = prev;
        
        if (left == 1) return prev;
        return head;
    }
}
