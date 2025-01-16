// leetcode 2
// two-pointers:first-second
// T: O(max(N1,N2))
// S: O(1)

/*
   nums are represented by linked-list with each node containing one digit reversely

   two-pointers -> first for l1, second for l2 -> handle the situation of carry
   -> build linked-list
*/

//- carry for extra node:
//- N1 != N2: digit = 0 if pointer = null
//- 0 and 0: dummy head
//- one is 0: return the other

class Solution {
    /** Return the linked-list of sum added by reverse order num of l1 and l2 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // edge cases
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // const
        ListNode header = new ListNode(0); // dummy head
        // vars
        ListNode builder = header;
        int carry = 0;
        ListNode first = l1;
        ListNode second = l2;
        // pass max(l1, l2)
        while (first != null || second != null || carry != 0) {
            int digit1 = (first == null) ? 0 : first.val;
            int digit2 = (second == null) ? 0 : second.val;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int digit = sum % 10;
            builder.next = new ListNode(digit);
            builder = builder.next;
            first = (first == null) ? null : first.next;
            second = (second == null) ? null : second.next;
        }
        // return
        return header.next;
    }
}
