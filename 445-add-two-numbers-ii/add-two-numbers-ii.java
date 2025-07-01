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
                // System.out.println(l2.val);
        // System.out.print(l2.next.val);
        ListNode h1 = reverse(l1);
        ListNode h2 = reverse(l2);
        int length1 = checkLength(h1);
        int length2 = checkLength(h2);
        ListNode temp = null;
        // System.out.println(h2.val);
        // System.out.print(h2.next.val);
        // System.out.println(h1.val);
        if (length1 < length2) {
            temp = h1;
            h1 = h2;
            h2 = temp;
        }
        // System.out.println(h1.val);
        // System.out.print(h1.next.val);
        // System.out.println(h2.val);
        // System.out.println(h2.next.val);
        // System.out.println(length1+" "+length2);
        temp = h1;
        int carry = 0;
        ListNode prev= null;
        while (h1 != null && h2 != null) {
            int val = h1.val + h2.val + carry;
            carry = val / 10;
            h1.val = val % 10;
            prev = h1;
            h1 = h1.next;
            h2 = h2.next;
        }
        while (h1 != null) {
            int val = h1.val + carry;
            carry= val/ 10;
            h1.val =val% 10;
        // System.out.println(1);
            // if (h1.next == null) break;
            prev = h1;
            h1 = h1.next;
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return reverse(temp);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = reverse(head.next);
        head.next.next = head;
        // System.out.println(head.next.next.val);
        // System.out.println(temp.val);
        // System.out.println(temp.next.val);
        head.next = null;
        return temp;
    }

    public int checkLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}