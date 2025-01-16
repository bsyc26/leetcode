// leetcode 370
// prefix:pre-diff
// T: O(N+L) // N: updates.length
// S: O(L) // L: length

class Solution {
    /** Return arr after applying all the updates from arr[] init all zeros
      * updates[i] = [start-idx, end-idx, inc(increment)] */
    public int[] getModifiedArray(int length, int[][] updates) {
        // const
        int N = updates.length;
        int L = length;
        // res
        int[] res = new int[L];
        // vars
        int[] preDiff = new int[L]; // preDiff[i] = arr[i] - arr[i-1]
        // pass updates[][]
        for (int[] update : updates) {
            int first = update[0];
            int last = update[1];
            int incr = update[2];
            preDiff[first] += incr;
            if (last + 1 < L)
                preDiff[last+1] -= incr;
        }
        // pass preDiff[] && build res[]
        res[0] = preDiff[0];
        for (int i = 1; i < L; i++)
            res[i] = res[i-1] + preDiff[i];
        // return
        return res;
    }
}
