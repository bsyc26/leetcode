// leetcode 142
// two-pointers:fast-slow
// T: O(N) // N: num of nodes in linked-list
// S: O(1)

/*
   a linked-list might has cycle -> return the start node of cycle or null
   
   with cycle: 0..C..M..C..  x: 0..C, c: C..C, l: start..meet
   fast = 2*slow = x + l + nc; slow = x + l + mc
   -> x + l + nc = 2x + 2l + 2mc -> (n-2m)c = x + l => x = (n-2m)c - l
   fast then step x to finish another cycle and meet with slow

   without cycle: 0..null
   fast will reach end of linked-list or null while fast != slow
*/

//- null: return null
//- one node: return null
//- no-cycle linked-list: return null
//- avg case: return intersaction node

class Solution {
    /** Return the start node of cycle, else null */
    public ListNode detectCycle(ListNode head) {
        // edge cases
        if (head == null)
            return null;
        if (head.next == null)
            return null;
        // vars
        ListNode fast = head;
        ListNode slow = head;
        // two-pointers:fast-slow
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        // case: no cycle
        if (fast != slow)
            return null;
        // case: has cycle -> make fast and slow meet
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // return start of cycle
        return slow;
    }
}
