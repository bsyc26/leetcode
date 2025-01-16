// leetcode 424
// sliding-window + hash:char-count-arr
// T: O(N) // N: s.length()
// S: O(1)

class Solution {
    /** Return the max len of sub str contains same char with at most k replacement of char */
    public int characterReplacement(String s, int k) {
        // const
        int N = s.length();
        // edge case
        if (N == 0 || N == 1) return N;
        // res
        int res = 0; // max len of qualified sub str
        // var
        int[] count = new int[256]; // count[char] = count of char
        int left = 0;
        int right = 0;
        int winMaxCount = 0; // max count of char in win
        // pass String s
        while (right < N) {
            // step right
            char c = s.charAt(right);
            ++count[c];
            winMaxCount = Math.max(winMaxCount, count[c]);
            ++right;
            // step left
            while (left < right && right-left-winMaxCount > k) {
                char d = s.charAt(left);
                --count[d];
                ++left;
            }
            // update res
            res = Math.max(res, right-left);
        }
        // return
        return res;
    }
}
