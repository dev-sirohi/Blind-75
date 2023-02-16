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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        Boolean flag = false;

        while (head.next != null && head.val == head.next.val) {
            head = head.next;
            flag = true;
        }

        if (flag) {
            head = head.next;
        }

        if (head == null) return null;

        ListNode ptr = head;
        ListNode prev = new ListNode(0, ptr);
        head = prev;

        while (ptr != null && ptr.next != null) {
            if (ptr.val == ptr.next.val) {
                while (prev.next.val == ptr.val) {
                    ptr = ptr.next;
                    if (ptr == null) break;
                }

                prev.next = ptr;
            } else {
                ptr = ptr.next;
                prev = prev.next;
            }
        }

        return head.next;
    }
}
