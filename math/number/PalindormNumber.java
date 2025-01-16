// leetcode 9
// math
// T: O(logN) // N: x
// S: O(1)

class Solution {
    /** Return true if x is palindrome */
    public boolean isPalindrome(int x) {
        // edge case
        if (x < 0) return false;
        // vars
        long rev = 0;
        int num = x;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        // return condition
        return rev == x;
    }
}
