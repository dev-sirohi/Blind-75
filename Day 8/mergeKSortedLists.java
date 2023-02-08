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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int size = lists.length;

        for (int i = 1; i < size; i++) {
            lists[0] = mergeTwoLists(lists[0], lists[i]);
        }

        return lists[0];
    }

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // In-place

        ListNode p1, p2, res;

        if (list1.val <= list2.val) {
            p1 = list1;
            p2 = list2;
            res = list1;
        } else {
            p1 = list2;
            p2 = list1;
            res = list2;
        }

        while (p1 != null && p2 != null) {
            if (p1.next != null && p2.val > p1.next.val) {
                p1 = p1.next;
            } else if (p1.next != null && p2.val <= p1.next.val) {
                ListNode temp = p1.next;
                p1.next = new ListNode(p2.val, temp);
                p1 = p1.next;
                p2 = p2.next;
            } else {
                p1.next = p2;
                break;
            }
        }

        return res;
    }
}
