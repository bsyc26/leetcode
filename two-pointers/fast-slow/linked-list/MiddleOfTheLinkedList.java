// leetcode 876
// two-pointers:fast-slow
// T: O(N) // N: num of nodes in linked-list
// S: O(1)

/*
   given a linked-list head, return the mid node (or mid-right if tot even nodes)
   
   two-pass: 1st get size; 2nd locate mid
   
   one-pass: two-pointers -> fast: steps two && reaches end node/null
   -> slow: steps one; is the mid node
*/

//- null: return null
//- one node: no enter while-loop, return first node
//- two nodes: fast reaches null, slow is mid-right (end node)
//- three nodes: fast reaches end, slow is the mid node

class Solution {
    /** Return the mid node of linked-list*/
    public ListNode middleNode(ListNode head) {
        // edge cases
        if (head == null) // null list
            return null;
        if (head.next == null) // one node
            return head;
        // vars
        ListNode fast = head;
        ListNode slow = head;
        // two-pointers:fast-slow
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // return
        return slow;
    }
}
