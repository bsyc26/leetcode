// leetcode 852
// binary-search
// T: O(logN) // N: arr.length;
// S: O(1)

class Solution {
    /** Return the index of peak elem of arr[], guaranteed solvable
      * arr[]: val incre to peak elem and then decre
      * peak elem: lt its neighbor */
    public int peakIndexInMountainArray(int[] arr) {
        // const
        int N = arr.length;
        // edge cases
        if (N == 0) return -1;
        if (N == 1) return 0;
        // vars
        int lo = 0;
        int hi = N-1;
        // binary pass arr[]
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int midVal = arr[mid];
            int compVal = (mid+1 < N) ? arr[mid+1] : arr[mid-1];
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
