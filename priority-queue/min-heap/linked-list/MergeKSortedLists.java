// leetcode 23
// priority-queue:min-heap
// T: O(NlogK) // N is the num of all nodes, k is num of linked-lists
// S: O(K)

import java.util.PriorityQueue;

class Solution {
    /** Merge all sorted increasing linked-list into one sorted increasing linked-list and return it */
    public ListNode mergeKLists(ListNode[] lists) {
        // const
        int K = lists.length;
        // edge case
        if (K == 0)
            return null;
        // DS -- min-heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>( // stores head node of all lists
            (a, b) -> Integer.compare(a.val, b.val) // order: increasing val
        );
        for (ListNode head : lists)
            if (head != null)
                pq.offer(head);
        // res
        ListNode vHead = new ListNode(Integer.MIN_VALUE); // dummy head of return linked-list
        ListNode builder = vHead;
        // priority-queue
        while (!pq.isEmpty()) {
            // poll
            ListNode minNode = pq.poll();
            // update res
            builder.next = minNode;
            builder = builder.next;
            // offer
            if (minNode.next != null)
                pq.offer(minNode.next);
        }
        // return
        return vHead.next;
    }
}
