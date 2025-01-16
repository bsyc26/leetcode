// leetcode 151
// string-builder
// T: O(N) // N: s.length()
// S: O(N)

// "":
// "c":
// leading/trailing spaces: pre
// middle spaces > 1: post


class Solution {
    /** Return a String with all words in s reversed and no extra spaces */
    public String reverseWords(String s) {
        // edge cases
        if (s.length() == 0 || s.length() == 1) return s;
        // trim leading, trailing and middle extra spaces
        StringBuilder sb = trim(s);
        // reverse all chars
        reverse(sb, 0, sb.length()-1);
        // reverse per word
        reverseWords(sb);
        // return
        return sb.toString();
    }

    // remove leading, trailing and extra middle spaces
    private StringBuilder trim(String s) { // build sb for extra middle spaces
        int left = 0;
        int right = s.length()-1;
        while (left < right && s.charAt(left) == ' ')
            ++left;
        while (left < right && s.charAt(right) == ' ')
            --right;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ')
                sb.append(c);
            else if (c == ' ' && sb.charAt(sb.length()-1) != ' ')
                sb.append(c);
            ++left;
        }
        return sb;
    }

    // reverse
    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, tmp);
            ++left;
            --right;
        }
    }

    // reverse per word
    private void reverseWords(StringBuilder sb) {
        int N = sb.length();
        int start = 0;
        int end = 0;
        while (start < N) {
            while (end < N && sb.charAt(end) != ' ')
                ++end;
            reverse(sb, start, end-1);
            start = end+1;
            ++end;
        }
    }
}
