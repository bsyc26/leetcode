// leetcode 21
// two-pointers:first-second
// T: O(M+N) // M: size of list1, N: size of list2
// S: O(1)

class Solution {
    /** Return the head of merged linked list from two sorted linked list */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // edge case
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;
        // const
        ListNode header = new ListNode(0); // dummy head
        // vars
        ListNode builder = header;
        ListNode first = list1;
        ListNode second = list2;
        // two-pointers:first-second
        while (first != null && second != null) {
            if (first.val > second.val) {
                builder.next = second;
                second = second.next;
            } else {
                builder.next = first;
                first = first.next;
            }
            builder = builder.next;
        }
        // conn remains
        if (first != null)
            builder.next = first;
        if (second != null)
            builder.next = second;
        // return head
        return header.next;
    }
}
