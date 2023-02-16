// Pay attention dumb fuck. There's no need for count, just use if sum > 9
// Brought up the space complexity pass from 60% to 90%

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode p1 = l1, p2 = l2;
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode p3 = res;
        
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum %= 10;
            } else {
                carry = 0;
            }

            p3.next = new ListNode(sum);

            p3 = p3.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int sum = p1.val + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum %= 10;
            } else {
                carry= 0;
            }

            p3.next = new ListNode(sum);
            p3 = p3.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int sum = p2.val + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum %= 10;
            } else {
                carry= 0;
            }

            p3.next = new ListNode(sum);
            p3 = p3.next;
            p2 = p2.next;
        }

        if (carry > 0) {
            p3.next = new ListNode(carry);
        }

        return reverseList(res.next);
    }

    ListNode reverseList(ListNode head) {
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

/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode p1 = l1, p2 = l2;
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode p3 = res;
        
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            if (!count(sum)) {
                carry = sum / 10;
                sum %= 10;
            } else {
                carry = 0;
            }

            p3.next = new ListNode(sum);

            p3 = p3.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int sum = p1.val + carry;
            if (!count(sum)) {
                carry = sum / 10;
                sum %= 10;
            } else {
                carry= 0;
            }

            p3.next = new ListNode(sum);
            p3 = p3.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int sum = p2.val + carry;
            if (!count(sum)) {
                carry = sum / 10;
                sum %= 10;
            } else {
                carry= 0;
            }

            p3.next = new ListNode(sum);
            p3 = p3.next;
            p2 = p2.next;
        }

        if (carry > 0) {
            p3.next = new ListNode(carry);
        }

        return reverseList(res.next);
    }

    ListNode reverseList(ListNode head) {
        ListNode ptr = head, prev = null;

        while (ptr != null) {
            ListNode next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }

        return prev;
    }

    Boolean count(int num) {
        if (num / 10 != 0) return false;
        return true;
    }
}
*/
