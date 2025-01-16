// leetcode 125
// two-pointers:left-right
// T: O(N) // N: s.length()
// S: O(1)

//- N = 0, N = 1: return true
//- upper/lowercase
//- all non-alnum
//- odd or even alnum

class Solution {
    /** Return true if s is palindorme, with uppercase converting to lower, non-alpha removing */
    public boolean isPalindrome(String s) {
        // const
        int N = s.length();
        // vars
        int left = 0;
        int right = N-1;
        // pass String s
        while (left < right) {
            // jump non-alnum
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                ++left;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                --right;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            ++left;
            --right;
        }
        // return fallback
        return true;
    }
}
