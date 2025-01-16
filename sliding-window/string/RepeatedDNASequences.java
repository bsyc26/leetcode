// leetcode 187
// slinding-window + Rabin-Karp
// T: O(N)~O(NL) // N: s.length(), L: 10
// S: O(N)

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    /** Return all 10-letter-long substr occur gt once in DNA mole
      * DNA seq: composed of 'A', 'C', 'G', 'T' */
    public List<String> findRepeatedDnaSequences(String s) {
        // const
        int N = s.length();
        // edge cases
        if (s == null || N < 10) return new ArrayList<>();
        // res set
        HashSet<String> res = new HashSet<>();
        // vars
        int[] rk = new int[N]; // str to 4-based num arr
        for (int i = 0; i < N; i++) {
            switch (s.charAt(i)) {
                case 'A' -> rk[i] = 0;
                case 'C' -> rk[i] = 1;
                case 'G' -> rk[i] = 2;
                case 'T' -> rk[i] = 3;
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        int L = 10; // bits
        int R = 4; // base
        int RL = (int)Math.pow(R, L-1);
        int left = 0;
        int right = 0;
        int winHash = 0;
        // pass String s
        while (right < N) {
            // step right
            winHash = R * winHash + rk[right]; // add lowest bit
            ++right;
            // step left
            if (right - left == L) {
                if (visited.contains(winHash))
                    res.add(s.substring(left, right));
                else
                    visited.add(winHash);
                winHash -= rk[left] * RL; // delete highest bit
                ++left;
            }
        }
        // return convertion
        return new ArrayList<>(res);
    }
}
