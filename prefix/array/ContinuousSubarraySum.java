// leetcode 523
// prefix:pre-sum + hash:hash-map + mono-state
// T: O(N) // N: nums.length
// S: O(N)

import java.util.HashMap;

class Solution {
    /** Return true if nums[] has a good subarray
      * good subarray: len at least 2; sum of elems is multiple of k */
    public boolean checkSubarraySum(int[] nums, int k) {
        // const
        int N = nums.length;
        // edge cases
        if (N < 2) return false;
        // vars
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // preSum: index
        map.put(0, -1);
        // pass nums[]
        for (int i = 0; i < N; i++) {
            preSum += nums[i];
            if (k != 0)
                preSum %= k;
            if (map.containsKey(preSum) && i - map.get(preSum) >= 2)
                return true;
            else
                map.putIfAbsent(preSum, i);
        }
        // return fallback
        return false;
    }
}
