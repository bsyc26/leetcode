// leetcode 28
// string
// T: O(NL) // N: haystack.length(), L: needle.length()
// S: O(1)

class Solution {
    /** Return the first index of needle in haystack, else -1 */
    public int strStr(String haystack, String needle) {
        // consts
        int N = haystack.length();
        int L = needle.length();
        // edge cases
        if (N == 0 || N < L) return -1;
        // pass String haystack
        for (int i = 0; i+L <= N; i++) {
            if (haystack.substring(i, i+L).equals(needle))
                return i;
        }
        // return fallback
        return -1;
    }
}
