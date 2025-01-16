// leetcode 61
// linked-list + iteration
// T: O(N) // N: num of nodes in linked-list
// S: O(1)

//- null list:
//- one node:
//- k > N: k % N
//- avg case: head move k, N-k node move to newHead

public class Solution {
    /** Rotate the list to right by k */
    public ListNode rotateRight(ListNode head, int k) {
        // edge cases
        if (head == null || head.next == null) return head;
        // vars
        int size = 1;
        ListNode walker = head;
        // step to last node
        while (walker.next != null) {
            walker = walker.next;
            size++;
        }
        // conn last to first to make circle
        walker.next = head;
        // var
        int steps = size - k % size;
        for (int i = 0; i < steps; i++)
            walker = walker.next;
        // make newHead && break circle
        ListNode newHead = walker.next;
        walker.next = null;
        // return
        return newHead;
    }
}
