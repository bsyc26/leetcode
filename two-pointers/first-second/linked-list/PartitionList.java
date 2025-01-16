// leetcode 86
// two-pointers:first-second
// T: O(N) // N is the size of givn linked-list
// S: O(1)

class Solution {
    /** Move all nodes less than x come before node greater or equal to x */
    public ListNode partition(ListNode head, int x) {
        // vars
        ListNode vFirst = new ListNode(0); // dummy head of first
        ListNode vSecond = new ListNode(0); // dummy head of second
        ListNode first = vFirst; // ptr of nodes with vals < x
        ListNode second = vSecond; // ptr of nodes with vals >= x
        // pass linked-list
        for (ListNode walker = head; walker != null; walker = walker.next) {
            if (walker.val < x) {
                first.next = walker;
                first = first.next;
            } else {
                second.next = walker;
                second = second.next;
            }
        }
        second.next = null; // tail op to prevent cycle
        // conn two partition
        first.next = vSecond.next;
        // return
        return vFirst.next;
    }
}
