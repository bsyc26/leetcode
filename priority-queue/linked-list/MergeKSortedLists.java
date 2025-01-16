// leetcode 23
// priority-queue:min-heap
// T: O(NlogK) // N: num of nodes in lists[], K: lists.length
// S: O(K)

//- [[]]: return null
//- [[], [1->2]]: jump []
//- []: return null

import java.util.PriorityQueue;

class Solution {
    /** Merge all sorted ascending linked-list into one sorted */
    public ListNode mergeKLists(ListNode[] lists) {
        // edge case
        if (lists.length == 0) return null;
        // const
        ListNode header = new ListNode(0); // dummy head
        // vars
        ListNode builder = header;
        PriorityQueue<ListNode> pq = new PriorityQueue<>( // ascending
            (a, b) -> Integer.compare(a.val, b.val)
        );
        for (ListNode head : lists) {
            if (head != null)
                pq.offer(head);
        }
        // pass all nodes
        while (!pq.isEmpty()) {
            // poll
            ListNode minNode = pq.poll();
            // update builder
            builder.next = minNode;
            builder = builder.next;
            // offer
            if (minNode.next != null)
                pq.offer(minNode.next);
        }
        // return
        return header.next;
    }
}
