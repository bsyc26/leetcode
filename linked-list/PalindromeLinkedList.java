// leetcode 234
// linked-list + two-pointers:fast-slow + two-pointers:first-second
// T: O(N) // N: num of nodes in linked-list
// S: O(1)

//- null list: return true
//- one node: return true
//- odd nodes: 1 -> 2 -> 1 // first: 1->2->1 second 2<-1
//- even nodes: 1 -> 1

class Solution {
    /** Return true if linked-list is palindrome */
    public boolean isPalindrome(ListNode head) {
        // edge cases    
        if (head == null || head.next == null) return true;
        // vars
        ListNode fast = head;
        ListNode slow = head;
        ListNode preMid = new ListNode(0);
        preMid.next = slow;
        // move slow to mid node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            preMid = preMid.next;
        }
        // vars
        ListNode first = head;
        ListNode second = reverseList(slow);
        ListNode revHead = second;
        // pass first and second half of linked-list
        while (second != null) {
            if (first.val != second.val) {
                preMid.next = reverseList(revHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        // return fallback
        preMid.next = reverseList(revHead);
        return true;
    }

    // reverse linked-list && return new head
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pred = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode succ = curr.next;
            curr.next = pred;
            pred = curr;
            curr = succ;
        }
        return pred;
    }
}
