// leetcode 1836
// two-pointers:fast-slow + hash:hash-map
// T: O(N) // N: num of nodes in linked-list
// S: O(N)

/*
   unsorted, del all node whose value appears more than once

   two-pointers + hash: 1st build the {val: cnt}; 2nd build the de-dup list
   -> fast: jump dup node -> slow: conn non-dup node
*/

//- null: return null
//- one node: return head
//- dup head: dummy head
//- all dup: dummy head

import java.util.HashMap;

class Solution {
    /** Return the head of list after all dep node deleted */
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        // edge cases
        if (head == null) return null;
        if (head.next == null) return head;
        // const
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // var
        HashMap<Integer, Integer> map = new HashMap<>(); // value: count
        // pass linked-list
        for (ListNode p = head; p != null; p = p.next)
            map.put(p.val, map.getOrDefault(p.val,0)+1);
        // vars
        ListNode fast = head;
        ListNode slow = dummyHead;
        // pass linked-list
        while (fast != null) {
            // jump dup
            while (fast != null && map.get(fast.val) > 1)
                fast = fast.next;
            // step slow
            if (fast != null && fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            // step fast
            if (fast != null)
                fast = fast.next;
        }
        // tail operation
        slow.next = null;
        // return
        return dummyHead.next;
    }
}

class Solution { // one-pointer
    /** Return the head of list after all dep node deleted */
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        // edge cases
        if (head == null) return null;
        if (head.next == null) return head;
        // const
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // var
        HashMap<Integer, Integer> map = new HashMap<>(); // value: count
        // pass linked-list
        for (ListNode p = head; p != null; p = p.next)
            map.put(p.val, map.getOrDefault(p.val,0)+1);
        // vars
        ListNode builder = dummyHead;
        while (builder != null) {
            // find next uniq node
            ListNode uniq = builder.next;
            while (uniq != null && map.get(uniq.val) > 1)
                uniq = uniq.next;
            // build uniq list
            builder.next = uniq;
            builder = builder.next;
        }
        // return
        return dummyHead.next;
    }
}
