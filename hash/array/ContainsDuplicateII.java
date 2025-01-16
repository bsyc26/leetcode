// leetcode 219
// hash:hash-set
// T: O(N) // N: nums.length
// S: O(k)

import java.util.HashSet;

class Solution {
    /** Return true if existing indices i, j (nums[i] == nums[j] and abs(i-j) lteq k */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1) return false;
        // vars
        HashSet<Integer> set = new HashSet<>(); // visited nums[i] withing k range
        // pass nums[]
        for (int i = 0; i < N; i++) {
            int curVal = nums[i];
            if (set.contains(curVal))
                return true; 
            // update set
            set.add(curVal);
            if (i >= k)
                set.remove(nums[i-k]);
        }
        // return fallback
        return false;
    }
}
