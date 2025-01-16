// leetcode 19
// two-pointers:fast-slow
// T: O(N) // N: num of nodes in linked-list
// S: O(1)

/*
   given a head of linked-list and n, remove the n-th node from the end and return
   
   two-pass: 1st get size; 2nd remove n-th node
   
   one-pass: two-pointers -> fast: steps n && ends at last node (N-1)
   -> slow: steps N-n-1 && ends at node before del node
*/

//- null: return null
//- one node: return head
//- del head: dummy head

class Solution {
    /** Remove n-th node from the end of linked-list and return its head */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // edge cases
        if (head == null || head.next == null) // null list || one node
            return null;
        // vars
        ListNode vHead = new ListNode(0); // dummy head
        vHead.next = head;
        ListNode fast = vHead;
        ListNode slow = vHead;
        // fast steps n
        for (int i = 0; i < n; i++)
            fast = fast.next;
        // fast && slow step N-n-1
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // del n-th node at n-1 node
        slow.next = slow.next.next;
        // return
        return vHead.next;
    }
}
