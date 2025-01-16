// leetcode 528
// prefix:pre-sum + random + binary-search:lower-bound
// T: O(logN) // N: w.length
// S: O(N)

import java.util.Random;

class Solution {
    // fields
    private int[] preSum; // preSum[i] = sum(w[0]..w[i])
    private Random rand;

    // constructor
    public Solution(int[] w) { // T: O(N), S: O(N)
        // const
        int N = w.length;
        // fields
        preSum = new int[N]; 
        preSum[0] = w[0]; 
        for (int i = 1; i < N; i++)
            preSum[i] = preSum[i-1] + w[i];
        rand = new Random();
    }
    
    /** REturn i-th index with weight of w[i] */
    public int pickIndex() { // T: O(logN)
        // const
        int N = preSum.length;
        // vars
        int totSum = preSum[N-1];
        int target = rand.nextInt(totSum) + 1; // [1..totSum]
        int lo = 0;
        int hi = N-1;
        // pass [lo..hi]
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int midSum = preSum[mid];
            if (midSum > target)
                hi = mid-1;
            else if (midSum < target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        // return
        return lo;
    }
}
