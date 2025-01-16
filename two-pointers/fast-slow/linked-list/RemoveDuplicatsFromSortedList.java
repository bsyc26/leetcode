// leetcode 83
// two-pointers:fast-slow
// T: O(N) // num of nodes in linked-list
// S: O(1)

//- null: return null
//- one node: return head

class Solution {
    /** Del all extra dup nodes of sorted list and return the uniq list */
    public ListNode deleteDuplicates(ListNode head) {
        // edge cases
        if (head == null || head.next == null) return head;
        // vars
        ListNode fast = head;
        ListNode slow = head; // always keep head node
        // pass linked-list with fast
        while (fast != null) {
            // step slow
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            // step fast
            fast = fast.next;
        }
        // make slow node the last
        slow.next = null;
        // return
        return head;
    }
}
