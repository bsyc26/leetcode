// leetcode 560
// prefix:pre-Sum + hash:hash-map + mono-state
// T: O(N) // N: nums.length;
// S: O(N)

import java.util.HashMap;

class Solution {
    /** REturn the tot num of subarr whose sum equal to k */
    public int subarraySum(int[] nums, int k) {
        // const
        int N = nums.length;
        // res
        int res = 0; // count of eligible subarr
        // vars
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // preSum: count
        map.put(0, 1);
        // pass nums[]
        for (int i = 0; i < N; i++) {
            preSum += nums[i];
            res += map.getOrDefault(preSum-k, 0);
            map.put(preSum, map.getOrDefault(preSum,0)+1);
        }
        // return
        return res;
    }
}
