// leetcode 658
// binary-search:lower-bound
// T: O(log(N-k)) // N: arr.length
// S: O(1)

import java.util.List;
import java.util.Arrays;

class Solution {
    /** Return the k closest elem vals to x in sorted arr[] in a List
      * closer: less abs diff or minor val if eq abs diff */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // const
        int N = arr.length;
        // vars
        int lo = 0;
        int hi = N-1-k;
        // pass arr[]
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int midDiff = x - arr[mid];
            int compDiff = arr[mid+k] - x;
            if (midDiff > compDiff)
                lo = mid+1; 
            else if (midDiff < compDiff)
                hi = mid-1;
            else
                hi = mid-1;
        }
        // return res
        return Arrays.stream(arr, lo, lo+k).boxed().toList(); // > Java 16
    }
}
