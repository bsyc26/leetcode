// leetcode 1094
// prefix:pre-diff
// T: O(N) // N: trips.length
// S: O(N)

class Solution {
    /** Return true if possible to pick-up and drop-off all people for given trips
      * trips[i] = [numPeople, from, to] */
    public boolean carPooling(int[][] trips, int capacity) {
        // const
        int N = trips.length;
        // vars
        int[] preDiff = new int[1001];
        // pass trips[][]
        for (int[] trip : trips) {
            int incr = trip[0];
            int from = trip[1];
            int to = trip[2];
            preDiff[from] += incr;
            preDiff[to] -= incr; // -incr not apply for to
        }
        // pass preDiff[] 
        int num = preDiff[0];
        if (num > capacity) return false;
        for (int i = 1; i < preDiff.length; i++) {
            num += preDiff[i];
            if (num > capacity)
                return false;
        }
        // return fallback
        return true;
    }
}
