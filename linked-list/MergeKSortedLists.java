// leetcode 23
// linked-list + division
// T: O(NlogK) // N: num of nodes in total, K: lists.length
// S: O(logK) // call-stack

//- lists.length == 0

class Solution {
    /** Merge all incr linked-list into one and return the head */
    public ListNode mergeKLists(ListNode[] lists) {
        // edge case
        if (lists.length == 0) return null;
        // return recursion
        return division(lists, 0, lists.length-1);
    }

    // merge list[first..end] into one incr linked-list
    private ListNode division(ListNode[] lists, int first, int last) {
        // base case
        if (first == last)
            return lists[first];
        // division
        int mid = first + (last-first)/2;
        ListNode left = division(lists, first, mid);
        ListNode right = division(lists, mid+1, last);
        // return
        return merge2(left, right);
    }

    // merge two incr linked-list into one and return its head
    private ListNode merge2(ListNode list1, ListNode list2) {
        // base cases
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        // recursion
        if (list1.val < list2.val) {
            list1.next = merge2(list1.next, list2);
            return list1;
        } else {
            list2.next = merge2(list1, list2.next);
            return list2;
        }
    }
}
