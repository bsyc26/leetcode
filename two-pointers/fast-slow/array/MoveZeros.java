// leetcode 283
// two-pointers:fast-slow
// T: O(N) // N: nums.length
// S: O(1)

//- []: return
//- [0]: return
//- [1]: return
//- [0, 1]: [1, 0]
//- [1, 0, 1]: [1, 1, 0]

class Solution {
    /** Move all 0's to end and keep non-0's order of nums[] in-place */
    public void moveZeroes(int[] nums) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0 || N == 1) return;
        // vars
        int fast = 0;
        int slow = 0;
        // pass nums[] with fast
        while (fast < N) {
            // step slow
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            // step fast
            fast++;
        }
        // fill-in 0's in the left nums[]
        while (slow < N) {
            nums[slow] = 0;
            slow++;
        }
    }
}
