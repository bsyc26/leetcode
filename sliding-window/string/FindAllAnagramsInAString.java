// leetcode 438
// sliding-window + hash:char-array
// T: O(N+L) // N: s.length(), L: p.length()
// S: O(1) // char-array

import java.util.List;
import java.util.ArrayList;

class Solution {
    /** Return an arr of all start indices of p's anagrams in s
      * anagram: re-arrangement of chars of p */
    public List<Integer> findAnagrams(String s, String p) {
        // consts
        int N = s.length();
        int L = p.length();
        // edge cases
        if (N == 0 || L == 0 || N < L) return new ArrayList<Integer>();
        // res
        List<Integer> res = new ArrayList<>(); // start index of anagrams of p in s 
        // vars
        int target = L;
        int[] count = new int[256];
        for (int i = 0; i < L; i++)
            ++count[p.charAt(i)];
        int left = 0;
        int right = 0;
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
                if (right - left == L)
                    res.add(left);
                char d = s.charAt(left);
                ++count[d];
                if (count[d] > 0)
                    ++target;
                ++left;
            }
        }
        // return
        return res;
    }
}
