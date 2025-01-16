// leetcode 76
// sliding-window + hash:char-array
// T: O(N+L) // N: s.minLength(), L: t.minLength()
// S: O(1) // char-array

class Solution {
    /** Return the min substr of s contains all including dup chars of t, else "" */
    public String minWindow(String s, String t) {
        // const
        int N = s.length();
        int L = t.length();
        // edge case
        if (N == 0 || L == 0 || N < L) return "";
        // vars
        int target = L; // required count of matching chars of t
        int[] count = new int[256];
        for (int i = 0; i < L; i++)
            ++count[t.charAt(i)];
        int left = 0;
        int right = 0;
        // res
        int minStart = -1;
        int minLen = Integer.MAX_VALUE;
        // pass String s
        while (right < N) {
            // step right
            char c = s.charAt(right);
            --count[c];
            if (count[c] >= 0)
                --target;
            ++right;
            // step left
            while (left < right && target == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }
                char d = s.charAt(left);
                ++count[d];
                if (count[d] > 0)
                    ++target;
                ++left;
            }
        }
        // return condition
        return (minStart == -1) ? "" : s.substring(minStart, minStart + minLen);
    }
}
