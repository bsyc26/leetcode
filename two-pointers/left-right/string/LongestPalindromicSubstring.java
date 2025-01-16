// leetcode 5
// two-pointers:left-right + recursion
// T: O(N^2) // N: s.length()
// S: O(1)

//- "": return ""
//- one char: return s

class Solution {
    // fields
    private int maxLen = 0;
    private int maxStart = 0; // res: s.substring(maxStart, maxStart+maxLen)

    /** Return the longest palindorm of String s */
    public String longestPalindrome(String s) {
        // edge case
        if (s == null) return null;
        // const
        int N = s.length();
        // edge cases
        if (N < 2) return s;
        // pass String s
        for (int i = 0; i < s.length(); i++) {
            findPlindrome(s, i, i); // odd
            findPlindrome(s, i, i+1); // even
            if (maxLen == s.length()) // most likely cut-branch
                break;
        }
        // return s.substring
        return s.substring(maxStart, maxStart+maxLen);
    }
    
    // find longest palindrome centered at left, right
    private void findPlindrome(String s, int left, int right) {
        // pass String s
        while (left >= 0 && right <= s.length()-1
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // comp res
        int curLen = right-left-1; // palindrome [left+1, right-1]
        if (curLen > maxLen) {
            maxLen = curLen;
            maxStart = left+1;
        }
    }
}
