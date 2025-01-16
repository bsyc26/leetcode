// leetcode 340
// sliding-window + hash:char-cnt-arr
// T: O(N) // N: s.length()
// S: O(1) // char-cnt-arr

class Solution {
    /** Return the max len of substr of s contains at most k distinct char */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // const
        int N = s.length();
        // egde case
        if (k == 0) return 0;
        if (N == 0 || N == 1) return N;
        // res
        int res = 0; // max len of qualified sub str
        // vars
        int[] count = new int[256]; // char: count
        int left = 0;
        int right = 0;
        int winUniq = 0; // num of uniq char of win
        // pass String s
        while (right < N) {
            // step right
            char c = s.charAt(right);
            if (count[c] == 0)
                ++winUniq;
            ++count[c];
            ++right;
            // step left
            while (left < right && winUniq > k)  {
                char d = s.charAt(left);
                if (count[d] == 1)
                    --winUniq;
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
