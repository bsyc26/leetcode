// leetcode 88
// two-pointers:first-second + reverse
// T: O(M+N)
// S: O(1)

//- m = n = 0, n = 0: return
//- m = 0: copy nums2[n] into nums1[n]

class Solution {
    /** Merge sorted nums1[m], nums2[n] into nums1[m+n] */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // edge cases
        if (m == 0 && n == 0) return;
        if (n == 0) return;
        if (m == 0) System.arraycopy(nums2, 0, nums1, 0, n);
        // var
        int first = m-1;
        int second = n-1;
        // pass nums1[m+n] reversely with decr order
        for (int i = m+n-1; i >= 0; i--) {
            if (second < 0) break;
            if (first < 0) {
                System.arraycopy(nums2, 0, nums1, 0, second+1); // size of left nums2[]
                break;
            }
            int val1 = nums1[first];
            int val2 = nums2[second];
            if (val1 >= val2) {
                nums1[i] = val1;
                --first;
            } else {
                nums1[i] = val2;
                --second;
            }
        }
    }
}
