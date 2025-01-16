// leetcode 28
// sliding-window + Rabin-Karp
// T: O(N+L) // N: haystack.length(), L: needle.length()
// S: O(1)

class Solution {
    /** Return the 1st index of needle in haystack, else -1 */
    public int strStr(String haystack, String needle) {
        // consts
        int N = haystack.length();
        int L = needle.length();
        int R = 256; // radix
        int Q = 1_000_000_033; // big prime
        long RL = 1;
        for (int i = 0; i < L-1; i++)
            RL = (RL * R) % Q;
        long patHash = 0;
        for (int i = 0; i < L; i++)
            patHash = (R * patHash + needle.charAt(i)) % Q;
        // vars
        int left = 0;
        int right = 0;
        long winHash = 0;
        // pass String haystack
        while (right < N) {
            // step right
            winHash = ((R * winHash) % Q + haystack.charAt(right)) % Q;
            ++right;
            // step left
            if (right-left == L) {
                // update res
                if (winHash == patHash
                        && haystack.substring(left, right).equals(needle))
                    return left;
                winHash = (winHash - (haystack.charAt(left) * RL) % Q + Q) % Q;
                ++left;
            }
        }
        // return fallback
        return -1;
    }
}
