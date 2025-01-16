// leetcode 55
// greedy + mono-state
// T: O(N)
// S: O(1)

//- N == 0
//- N == 1
//- [2, 10000, 0, 5]

class Solution {
    /** Return true if can reach the last index
      * each non-negative nums[i] represents the max jump len */
    public boolean canJump(int[] nums) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1) return true;
        // var
        int maxReach = 0; // max reacheable index
        // pass nums[]
        for (int i = 0; i < N-1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach <= i)
                return false;
        }
        // return condition
        return maxReach >= N-1; 
    }
}
