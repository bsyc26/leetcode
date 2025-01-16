// leetcode 525
// prefix:pre-sum + hash:hash-map + mono-state
// T: O(N) // N: nums.length
// S: O(N)

import java.util.HashMap;

class Solution {
    /** Return the max len of subarray with equal num of 0 and 1 from binary nums[] */
    public int findMaxLength(int[] nums) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1) return 0;
        // res
        int res = 0; // max len of subarray with equal num of 0 and 1
        // vars
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // preSum: index
        map.put(0, -1);
        // pass nums[]
        for (int i = 0; i < nums.length; i++) {
            preSum += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(preSum))
                res = Math.max(res, i-map.get(preSum));
            else
                map.put(preSum, i);
        }
        // return
        return res;
    }
}
