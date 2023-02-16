// DUMBASS, I JUST TOLD YOU, PAY ATTENTION, YOUR FIRST INTUITION WAS CORRECT, WHY'D YOU MISS IT
// IDIOT

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
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head;

        head = reverse(head);

        ListNode ptr = head;
        while (ptr.next != null) {
            if (ptr.next.val < ptr.val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }

        return reverse(head);
    }

    ListNode reverse(ListNode head) {
        ListNode ptr = head, prev = null;

        while (ptr != null) {
            ListNode next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }

        return prev;
    }
}

/*

Brute force, gives TLE

ListNode slow = head, prev = new ListNode(0, head);

        while (slow.next != null) {
            ListNode fast = slow;
            Boolean flag = false;
            while (fast != null) {
                if (fast.val > slow.val) {
                    if (prev.next == head) {
                        prev.next = fast;
                        slow = fast;
                        head = slow;
                        flag = true;
                        break;
                    } else {
                        prev.next = fast;
                        slow = fast;
                        flag = true;
                        break;
                    }
                }
                fast = fast.next;
            }
            if (!flag) {
                slow = slow.next;
                prev = prev.next;
            }
        }

        return head;

*/
