// leetcode 25
// linked-list + recursion + iteration
// T: O(N)
// S: O(N)

//- num of nodes less than k*n: keep unchanged

class Solution {
    /** Reverse per k nodes of linked-list, the left remain */
    public ListNode reverseKGroup(ListNode head, int k) {
        // edge cases
        if (head == null || head.next == null) return head;
        // var
        ListNode last = head;
        // edge case
        for (int i = 0; i < k; i++) {
            if (last == null) return head;
            last = last.next;
        }
        // reverse first k nodes
        ListNode newHead = reverseN(head, k);
        // recursion
        head.next = reverseKGroup(last, k);
        // return
        return newHead;
    }

    // reverse n nodes
    ListNode reverseN(ListNode head, int n) {
        if (head == null | head.next == null) return head;
        ListNode pred = null;
        ListNode curr = head;
        while (curr != null && n > 0) {
            ListNode succ = curr.next;
            curr.next = pred;
            pred = curr;
            curr = succ;
            n--;
        }
        head.next = curr;
        return pred;
    }
}
