// leetcode 392
// two-pointers:fast-slow
// T: O(N+L) // N: t.length(), L: s.length()
// S: O(1)

class Solution {
    /** Return true if s is subseq of t, else false
      * subseq: substr with optional deleting chars */
    public boolean isSubsequence(String s, String t) {
        // consts
        int N = t.length();
        int L = s.length();
        // edge cases
        if (N < L) return false;
        // vars
        int fast = 0; // pass String t
        int slow = 0; // pass String s
        // pass String t, s
        while (fast < N && slow < L) {
            // step slow
            if (t.charAt(fast) == s.charAt(slow))
                ++slow;
            // step fast
            ++fast;
        }
        // return condition
        return slow == L;
    }
}
