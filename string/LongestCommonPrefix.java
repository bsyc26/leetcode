// leetcode 14
// string + iteration
// T: O(N*min(strs[i])) // N: str.length
// S: O(1)

//- N == 0
//- strs[i] == ''

class Solution {
    /** Return the max len common prefix else "" */
    public String longestCommonPrefix(String[] strs) {
        // edge cases
        if (strs == null || strs.length == 0) return "";
        // pass strs[0]
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            // pass strs[]
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        // return fallback
        return strs[0];
    }
}
