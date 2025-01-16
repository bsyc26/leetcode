// leetcode 45
// greedy + mono-state
// T: O(N) // N: nums.length
// S: O(1)

//- N == 0
//- N == 1
//- [2, 10000, 0, 5]

class Solution {
    /** Return the min jumps to reach last elem of nums[]
      * nums[i] represents max len of jump */
    public int jump(int[] nums) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1) return 0;
        // vars
        int maxReach = 0; // index of curr max reachable
        int landing = 0; // landing index of jump
        // res
        int step = 0;
        // pass nums[]
        for (int i = 0; i < N-1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= N-1)
                return step+1;
            if (i == landing) {
                ++step;
                landing = maxReach;
            }
        }
        // return fallback
        return -1;
    }
}
