// leetcode 83
// two-pointers:fast-slow
// T: O(N) // num of nodes in linked-list
// S: O(1)

/*
   given a sorted linked-list's head, remove all extra duplicate nodes and return

   two-pass: 1st record dup; 2nd build uniq

   one-pass: two-pointers -> fast: jump all dup, pause at uniq
   -> slow: build uniq linked-list
*/

//- null: return null
//- one node: return head
//- dup head: use dummy head

class Solution {
    /** Remove extra duplicate num from a sorted linked-list and return the head */
    public ListNode deleteDuplicates(ListNode head) {
        // vars
        ListNode vHead = new ListNode(0); // dummy head
        vHead.next = head;
        ListNode fast = head;
        ListNode slow = vHead;
        // two-pointers:fast-slow
        while (fast != null) {
            // jump dup
            while (fast.next != null && fast.val == fast.next.val)
                fast = fast.next;
            // step slow
            if (slow.next == fast)
                slow = slow.next;
            else
                slow.next = fast.next;
            // step fast
            fast = fast.next;
        }
        // return
        return vHead.next;
    }
}
