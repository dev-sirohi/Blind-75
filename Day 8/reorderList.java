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
    public void reorderList(ListNode head) {
        ListNode midNode = findMidNode(head);
        ListNode newNode;

        newNode = reverseLinkedList(midNode.next);
        midNode.next = null;
        head = merge(head, newNode);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode res = list1;

        while (list2 != null) {
            ListNode temp = list1.next;
            list1.next = new ListNode(list2.val, temp);
            list1 = list1.next.next;
            list2 = list2.next;
        }

        return res;
    }

    ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
