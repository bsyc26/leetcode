// leetcode 264
// dp-table
// T: O(N) // N: n
// S: O(N)

/*
    pass all nums, count the n-th ugly

    pass all candidates -> state: n is the nth ugly num
    -> transfer: n+1-th are min of candidates of dp[p] of 2, 3, 5
*/

//- n=1: return 1

class Solution {
    /** Return the n-th ugly num whose prime factors are 2, 3, 5 */
    public int nthUglyNumber(int n) {
        // vars
        int[] dp = new int[n+1]; // 0, 1..n
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        int cand2 = 1;
        int cand3 = 1;
        int cand5 = 1;
        // build dp[]
        for (int i = 1; i <= n; i++) { // 1-indexed
            // state transfer
            int cand = Math.min(cand2, Math.min(cand3, cand5));
            dp[i] = cand;
            // update candiates
            if (cand == cand2) {
                cand2 = 2 * dp[p2];
                p2++;
            }
            if (cand == cand3) {
                cand3 = 3 * dp[p3];
                p3++;
            }
            if (cand == cand5) {
                cand5 = 5 * dp[p5];
                p5++;
            }
        }
        // return
        return dp[n];
    }
}
