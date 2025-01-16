// leetcode 713
// sliding-window
// T: O(N) // N: nums.length
// S: O(1)

class Solution {
    /** Return the num of subarr with prod of elems lt k, nums[i] is pos int */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || k <= 1) return 0;
        // res
        int res = 0; // count of qualified subarr
        // vars
        int left = 0;
        int right = 0;
        int winProd = 1;
        // pass nums[]
        while (right < N) {
            // step right
            winProd *= nums[right];
            ++right;
            // step left
            while (left < right && winProd >= k) {
                winProd /= nums[left];
                ++left;
            }
            // update res
            res += right-left;
        }
        // return
        return res;
    }
}
