// leetcode 567
// sliding-window + hash:char-array
// T: O(M+L) // M: s2.length(), L: s1.length()
// S: O(1)

class Solution {
    /** Return true if s2 contains a perm of s1, else false
      * perm: re-arrangement of all chars of s1 */
    public boolean checkInclusion(String s1, String s2) {
        // consts
        int N = s2.length();
        int L = s1.length();
        // edge cases
        if (N == 0 || N < L) return false;
        if (L == 0) return true;
        // vars
        int target = L;
        int[] count = new int[256];
        for (int i = 0; i < L; i++)
            ++count[s1.charAt(i)];
        int left = 0;
        int right = 0;
        // pass String s2
        while (right < N) {
            // step right
            char c = s2.charAt(right);
            --count[c];
            if (count[c] >= 0)
                --target;
            ++right;
            // step left
            while (target == 0) {
                if (right - left == L)
                    return true;
                char d = s2.charAt(left);
                ++count[d];
                if (count[d] > 0)
                    ++target;
                ++left;
            }
        }
        // return fallback
        return false;
    }
}
