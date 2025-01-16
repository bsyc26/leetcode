// leetcode 344
// two-pointers:left-right
// T: O(N) // N: s.length
// S: O(1)

//- N == 0:
//- N == 1:

class Solution {    
    /** Reverse the s[] in-place */ 
    public void reverseString(char[] s) {
        // const
        int N = s.length;
        // edge cases
        if (N == 0 || N == 1) return; 
        // vars
        int left = 0;
        int right = N-1;
        // pass s[] with left-right
        while (left < right) {
            // swap
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            // step left, right
            left++;
            right--;
        }
    }
}
