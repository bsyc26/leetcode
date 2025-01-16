// leetcode 3
// sliding-window + hash:char-array
// T: O(N) // N: s.length()
// S: O(1) // char-array

class Solution {
    /** Return the max len of substring without repeating */
    public int lengthOfLongestSubstring(String s) {
        // consts
        int N = s.length();
        // edge case
        if (N == 0) return 0;
        // res
        int maxLen = 0;
        // var
        int[] count = new int[256];
        int left = 0;
        int right = 0;
        // pass String s
        while (right < N) {
            // step right
            char c = s.charAt(right);
            ++count[c];
            ++right;
            // step left
            while (left < right && count[c] > 1) {
                char d = s.charAt(left);
                --count[d];
                ++left;
            }
            // update res
            maxLen = Math.max(maxLen, right - left);
        }
        // return
        return maxLen;
    }
}
