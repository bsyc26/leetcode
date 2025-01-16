// leetcode 75
// two-pointers:first-second + quick-select
// T: O(N) // N: nums.length
// S: O(1)

// N = 0, N = 1: return;
// all 0


class Solution {
    /** Sort 0, 1, 2 of nums[] in-place */
    public void sortColors(int[] nums) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1) return;
        // vars
        int first = 0; // [0..first) is 0
        int second = N-1; // (second..N-1) is 2
        int i = 0; // [first..second] is 1
        // pass nums[]
        while (i <= second) {
            if (nums[i] == 0) {
                swap(nums, first, i);
                ++first;
                ++i;
            } else if (nums[i] == 2) {
                swap(nums, second, i);
                --second;
            } else {
                ++i;
            }
        }
    }

    // swap
    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}
