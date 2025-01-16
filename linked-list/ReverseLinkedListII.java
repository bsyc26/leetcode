// leetcode 92
// iteration
// T: O(N)
// S: O(1)

//- null
//- left = 1
//- left = right


class Solution {
    /** Reverse the nodes from pos left to right and return rev head */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // edge cases        
        if (head == null || head.next == null || left == right) return head;
        if (left == 1) return reverseN(head, right-left+1);
        // var
        ListNode pred = head;
        for (int i = 1; i < left-1; i++)
            pred = pred.next;
        // rev from m-th
        pred.next = reverseN(pred.next, right-left+1);
        // return
        return head;
    }

    // reverse for n nodes and return head
    private ListNode reverseN(ListNode head, int n) {
        // edge cases
        if (head == null || head.next == null) return head;
        // vars
        ListNode pred = null;
        ListNode curr = head;
        // pass linked-list
        while (curr != null && n > 0) {
            ListNode succ = curr.next;
            curr.next = pred;
            pred = curr;
            curr = succ;
            n--;
        }
        // conn cur with head(now tail)
        head.next = curr;
        // return
        return pred;
    }
}

// recursion
// T: O(N)
// S: O(N)

class Solution {
    /** Reverse the nodes from pos left to right and return rev head */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // edge cases
        if (head == null || head.next == null || left == right) return head;
        // base case
        if (left == 1)
            return reverseN(head, right-left+1);
        // recursion
        head.next = reverseBetween(head.next, left-1, right-1);
        // return
        return head;
    }

    // reverse linked-list for n nodes and return rev head
    private ListNode reverseN(ListNode head, int n) {
        // base case
        if (n == 1)
            return head;
        // recursion
        ListNode revHead = reverseN(head.next, n-1);
        ListNode succ = head.next;
        head.next = succ.next;
        succ.next = head;
        // return
        return revHead;
    }
}
