// leetcode 160
// two-pointers:first-second
// T: O(N) // N: num of nodes in linked-list
// S: O(1)

/*
listA and listB has diff sizes
listA+listB will yield the same size for two-pointers
*/

class Solution {
    /** Return the node where two lists intersect, else null */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // vars
        ListNode first = headA;
        ListNode second = headB;
        // two-pointers:first-second
        while (first != second) {
            first = (first == null) ? headB: first.next;
            second = (second == null) ? headA: second.next;
        }
        // return
        return first;
    }
}
