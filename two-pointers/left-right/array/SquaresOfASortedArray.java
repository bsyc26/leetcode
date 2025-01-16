// leetcoee 977
// two-pointers:left-right + reverse
// T: O(N) // N: nums.length
// S: O(1)

// N == 0
// N == 1
// [-5, 1, 3]: return [1, 9, 25]
// square -> int overflow

class Solution {
    /** Return an arr of square of nums[i] sorted non-decr, nums[] is sorted */
    public int[] sortedSquares(int[] nums) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0) return nums;
        if (N == 1) return new int[]{ nums[0] * nums[0] };
        // res
        int[] res = new int[N]; // res[] is sorted square of nums[]
        // vars
        int left = 0;
        int right = N-1;
        int i = N-1; // reversed builder ptr of res[]
        // pass nums[]
        while (left <= right) {
            int squareLeft = nums[left] * nums[left];
            int squareRight = nums[right] * nums[right];
            if (squareLeft > squareRight) {
                res[i] = squareLeft;
                ++left;
            } else {
                res[i] = squareRight;
                --right;
            }
            --i;
        }
        // return
        return res;
    }
}
