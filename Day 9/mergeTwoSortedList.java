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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);

        ListNode p1 = list1, p2 = list2, p3 = res;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p3.next = new ListNode(p1.val);
                p1 = p1.next;
                p3 = p3.next;
            } else {
                p3.next = new ListNode(p2.val);
                p2 = p2.next;
                p3 = p3.next;
            }
        }

        while (p1 != null) {
            p3.next = new ListNode(p1.val);
            p3 = p3.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            p3.next = new ListNode(p2.val);
            p3 = p3.next;
            p2 = p2.next;
        }

        return res.next;
    }
}
