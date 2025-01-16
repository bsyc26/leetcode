// leetcode 28
// sliding-window + Rabin-Karp
// T: O(N) // N: haystack.length()
// S: O(1)

class Solution {
    /** Return the first index of String needle in String haystack, else -1 */
    public int strStr(String haystack, String needle) {
        // edge cases
        if (haystack == null || needle == null) return -1;
        // consts
        int N = haystack.length();
        int L = needle.length();
        // edge cases
        if (N == 0 || L == 0 || N < L) return -1;
        // consts
        int R = 256;
        int Q = 1_000_000_033;
        long RL = 1;
        for (int i = 1; i <= L-1; i++)
            RL = (RL * R) % Q;
        long patHash = 0;
        for (int i = 0; i < L; i++)
            patHash = ((patHash * R) % Q + needle.charAt(i)) % Q;
        // vars
        int left = 0;
        int right = 0;
        long winHash = 0;
        // pass String haystack
        while (right < N) {
            // step right
            winHash = ((winHash * R) % Q + haystack.charAt(right)) % Q;
            ++right;
            // step left
            if (right - left == L) {
                // test match
                if (winHash == patHash
                        && haystack.substring(left, right).equals(needle)) // hash-collision
                    return left;
                winHash = (winHash - (haystack.charAt(left) * RL) % Q + Q) % Q;
                ++left;
            }
        }
        // return fallback
        return -1;
    }
}
