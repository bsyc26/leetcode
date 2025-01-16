// leetcode 1124
// prefix:pre-sum + hash:hash-map + mono-state
// T: O(N) // N: hours.length
// S: O(N)

import java.util.HashMap;

class Solution {
    /** Return the len of longest well-performing intv
      * well-performing intv: num of tiring day gt num of non-tiring day
      * tiring day: num of hours gt 8 */
    public int longestWPI(int[] hours) {
        // const
        int N = hours.length;
        // res
        int res = 0; // max len of well-performing intv
        // vars
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // preSum: index
        map.put(0, -1);
        // pass hours[]
        for (int i = 0; i < N; i++) {
            preSum += (hours[i] > 8) ? 1 : -1;
            if (preSum > 0)
                res = i + 1; 
            else if (map.containsKey(preSum-1))
                res = Math.max(res, i - map.get(preSum-1));
            map.putIfAbsent(preSum, i);
        }
        // return
        return res;
    }
}
