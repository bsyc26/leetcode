// leetcode 162
// binary-search:lower-bound
// T: O(logN) // N: nums.length
// S: O(1)

class Solution {
    /** Return the index of any peak elem of nums[]
      * peak elem: gt than its neighbors */
    public int findPeakElement(int[] nums) {
        // const
        int N = nums.length;
        // edge cases
        if (N == 0) return -1;
        if (N == 1) return 0;
        // vars
        int lo = 0;
        int hi = N-1;
        // binary pass lo..hi 
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2; 
            int midVal = nums[mid];
            int compVal = (mid+1 < N) ? nums[mid+1] : nums[mid-1];
            if (midVal > compVal)
                hi = mid-1;
            else if (midVal < compVal)
                lo = mid+1;
            else
                hi = mid-1;
        }
        // return
        return lo;
    }
}
