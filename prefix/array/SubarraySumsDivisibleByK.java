// leetcode 974
// prefix:pre-sum + hash:state-arr + mono-state
// T: O(N) // N: nums.length
// S: O(k)

class Solution {
    /** Return the num of non-empty subarr that sum divisible by k */
    public int subarraysDivByK(int[] nums, int k) {
        // const
        int N = nums.length;
        // res
        int res = 0; //
        // vars
        int preSum = 0;
        int[] count = new int[k];
        count[0] = 1;
        // pass nums[]
        for (int i = 0; i < N; i++) {
            preSum += (nums[i] + k) % k;
            preSum = (preSum + k) % k;
            res += count[preSum];
            ++count[preSum];
        }
        // return
        return res;
    }
}
