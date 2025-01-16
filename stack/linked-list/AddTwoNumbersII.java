// leetcode 445
// stack
// T: O(N1+N2)
// S: O(N1+N2)

/*
   linked-list representation of num: each node is one digit, no leading zero

   [X] adding start from the lowest digit -> reverse l1 and l2

   use stack for reverse -> Stack<ListNode> for l1 and l2
   -> build the sum linked-list reversely
*/

//- both null: return null
//- one is null: return the other
//- N1 != N2: leftmost carry will be extra node

import java.util.Stack;
import java.util.ArrayDeque;

class Solution {
    /** Return the linked-list of sum of l1 and l2 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // res
        ListNode builder = null;
        // vars
        Stack<ListNode> stk1 = new Stack<>();
        Stack<ListNode> stk2 = new Stack<>();
        ListNode first = l1;
        ListNode second = l2;
        while (first != null) {
            stk1.push(first);
            first = first.next;
        }
        while (second != null) {
            stk2.push(second);
            second = second.next;
        }
        int carry = 0;
        // pass max(N1, N2)
        while (!stk1.isEmpty() || !stk2.isEmpty() || carry != 0) {
            int digit1 = stk1.isEmpty() ? 0 : stk1.pop().val;
            int digit2 = stk2.isEmpty() ? 0 : stk2.pop().val;
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode curr = new ListNode(digit);
            curr.next = builder;
            builder = curr;
        }
        // return
        return builder;
    }
}
