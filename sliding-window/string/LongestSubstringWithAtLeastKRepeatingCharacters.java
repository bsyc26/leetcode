// leetcode 395
// sliding-window + hash:char-count-array + divide-conquer
// T: O(N) // N: s.length()
// S: O(1) // char-count-array

class Solution {
    /** Return the max len of substr that freq of all win chars gteq k, else 0*/
    public int longestSubstring(String s, int k) {
        // const
        int N = s.length();
        // edge cases
        if (N == 0 || N < k) return 0;
        // res
        int res = 0;
        // pass max num uniq char
        for (int i = 1; i <= 26; i++)
            res = Math.max(res, maxLenSubstringTargetUniq(s, k, i));
        // return
        return res;
    }

    // return the max len of substring with targetUniq char has count gteq k
    private int maxLenSubstringTargetUniq(String s, int k, int targetUniq) {
        // const
        int N = s.length();
        // res
        int res = 0;
        // vars
        int[] count = new int[256];
        int right = 0;
        int left = 0;
        int winUniq = 0;
        int winMatch = 0;
        // pass String s
        while (right < N) {
            // step right
            char c = s.charAt(right);
            if (count[c] == 0)
                ++winUniq;
            ++count[c];
            if (count[c] == k)
                ++winMatch;
            ++right;
            // step left
            while (left < right && winUniq > targetUniq) {
                char d = s.charAt(left);
                if (count[d] == k)
                    --winMatch;
                --count[d];
                if (count[d] == 0)
                    --winUniq;
                ++left;
            }
            // update res
            if (winMatch == targetUniq)
                res = Math.max(res, right-left);
        }
        // return
        return res;
    }
}
