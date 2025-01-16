// leetcode 187
// sliding-window + Rabin-Karp + hash:hash-set
// T: O(N) // N: s.length()
// S: O(N)

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {                    
    /** Return all repeated 10-letter-long substr of s   
      * DNA seq: composed by 'A', 'C', 'G', 'T" */       
    public List<String> findRepeatedDnaSequences(String s) {
        // edge cases
        if (s == null || s.length() == 0) return new ArrayList<>();
        // const
        int N = s.length();
        int R = 4; // radix
        int L = 10;
        int RL = (int)Math.pow(R, L-1); // val of one highest bit under radix base
        int Q = 1_000_000_033; // big prime
        int[] nums = new int[N]; // map String s to int[]
        for (int i = 0; i < N; i++) {
            nums[i] = switch (s.charAt(i)) { // > Java 14
                case 'A' -> 0;
                case 'C' -> 1;
                case 'G' -> 2;
                case 'T' -> 3;
                default -> -1; // prevent compile error (not matching all values)
            };
        }
        // res set
        HashSet<String> res = new HashSet<>();
        // vars
        HashSet<Integer> visited = new HashSet<>(); // visited winHash vals
        int left = 0;
        int right = 0;
        int winHash = 0;
        // pass String s
        while (right < N) {
            // step right
            winHash = ((winHash * R) % Q + nums[right]) % Q;
            ++right;
            // step left
            if (right - left == L) {
                // update res
                if (visited.contains(winHash))
                    res.add(s.substring(left, right));
                else 
                    visited.add(winHash);
                winHash = (winHash - (nums[left] * RL) % Q + Q) % Q;
                ++left;
            }
        }
        // return res
        return new ArrayList<>(res);
    }
}
