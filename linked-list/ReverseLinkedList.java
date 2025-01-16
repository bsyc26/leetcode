// leetcode 206
// iteration
// T: O(N) // N: num of nodes in linked-list
// S: O(1)

//- null: return null
//- one node (1->null): return null (null->1)
//- null<-1 2->null: null<-1<-2 null

class Solution {
    /** Reverse the linked-list and return the new head */
    public ListNode reverseList(ListNode head) {
        // edge cases
        if (head == null || head.next == null) return head;
        // vars
        ListNode pred = null;
        ListNode curr = head;
        // pass linked-list
        while (curr != null) {
            ListNode succ = curr.next;
            curr.next = pred;
            pred = curr;
            curr = succ;
        }
        // return new head
        return pred;
    }
}

// recursion
// T: O(N)
// S: O(N) // call-stack

//- .. -> head -> .. <- rev-head: .. -> (head -> null) <- .. <- rev-head

class Solution {
    /** Reverse the linked-list and return the new head */
    public ListNode reverseList(ListNode head) {
        // base case
        if (head == null || head.next == null)
            return head;
        // recursion
        ListNode revHead = reverseList(head.next); 
        head.next.next = head;
        head.next = null;
        // return
        return revHead;
    }
}
