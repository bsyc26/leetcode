// leetcode 209
// sliding-window
// T: O(N) // N: nums.length
// S: O(1)

class Solution {
    /** Return the min len of subarr with sum gteq target, else 0 */
    public int minSubArrayLen(int target, int[] nums) {
        // const
        int N = nums.length;
        // res
        int res = Integer.MAX_VALUE;
        // vars
        int left = 0;
        int right = 0;
        int winSum = 0;
        // pass nums[]
        while (right < N) {
            // step right
            winSum += nums[right];
            ++right;
            // step left
            while (left < right && winSum >= target) {
                res = Math.min(res, right-left); // update res
                winSum -= nums[left];
                ++left;
            }
        }
        // return condition
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}
