// leetcode 325
// prefix:pre-Sum + hash:hash-map + mono-state
// T: O(N) // N: nums.length
// S: O(N)

import java.util.HashMap;

class Solution {
    /** Return the max len of subarr sums to 0, else 0 */
    public int maxSubArrayLen(int[] nums, int k) {
        // const
        int N = nums.length;
        // res
        int res = 0; // max len of qualified subarr
        // vars
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // preSum: index
        map.put(0, -1);
        // pass nums[]
        for (int i = 0; i < N; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum-k))
                res = Math.max(res, i - map.get(preSum-k));
            map.putIfAbsent(preSum, i);
        }
        // return
        return res;
    }
}
