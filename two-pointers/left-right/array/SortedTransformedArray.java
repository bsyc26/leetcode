// leetcode 360
// two-pointers:left-right + condition
// T: O(N) // N: nums.length
// S: O(1)

// N == 0
// N == 1
// a > 0, a < 0: determine whether the mid or edge is the max f(x)

class Solution {
    /** Return an arr of sorted f(x)=ax^2+bx+c of sorted nums[i] */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0) return nums;
        if (N == 1) return new int[]{ f(nums[0], a, b, c) };
        // res
        int[] res = new int[N]; // res[] is sorted f(nums[i])
        // vars
        int left = 0;
        int right = N-1;
        int i = (a > 0) ? N-1 : 0; // a > 0, edge is max, i is res[] builder
        // pass nums[]
        while (left <= right) {
            int fvalLeft = f(nums[left], a, b, c);
            int fvalRight = f(nums[right], a, b, c);
            if (a > 0) { // nums[] left or right is max fval
                if (fvalLeft > fvalRight) {
                    res[i] = fvalLeft;
                    ++left;
                } else {
                    res[i] = fvalRight;
                    --right;
                }
                i--; // build decr
            } else { // nums[] left or right is min fval
                if (fvalLeft > fvalRight) {
                    res[i] = fvalRight;
                    --right;
                } else {
                    res[i] = fvalLeft;
                    ++left;
                }
                i++; // build incr
            }
        }
        // return
        return res;
    }

    // Return the value of f(x)
    private int f(int x, int a, int b, int c) {
        return (a * x + b) * x + c;
    }
}
