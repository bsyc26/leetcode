// leetcode 1109
// prefix:pre-diff
// T: O(max(N,L)) // N: bookings.length, L: n
// S: O(L)

class Solution {
    /** Return an arr[n] where arr[i] is tot num of seated reserved for flight i
      * bookings[i] = [first, last, seats] */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // consts
        int L = n;
        int N = bookings.length;
        // var
        int[] preDiff = new int[L]; // preDiff[i] = arr[i] - arr[i-1]
        // pass bookings[][]
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int incr = booking[2];
            preDiff[first-1] += incr;
            if (last < L)
                preDiff[last] -= incr;
        }
        // pass preDiff && build res[]
        int[] res = new int[L];
        res[0] = preDiff[0];
        for (int i = 1; i < L; i++)
            res[i] = res[i-1] + preDiff[i];
        // return
        return res;
    }
}
