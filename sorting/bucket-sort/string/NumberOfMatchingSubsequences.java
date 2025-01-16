// leetcode 792
// bucket-sort
// T: O()
// S: O()

import java.util.List;
import java.util.Arraylist;

class Solution {
    // nested record
    private record Pair(int cur, int next) {} // cur ch and next awaiting ch of words[i]

    /** Return the num of words[i] being a subseq of String s
      * subseq: substr with optional deleting chars */
    public int numMatchingSubseq(String s, String[] words) {
        // const
        int N = words.length;
        int L = s.length();
        // edge case
        if (N == 0) return 0;
        // res
        int res = 0; // count of qualified words[i]
        // var
        ArrayList<Pair>[] bucket = new ArrayList[256]; 
        for (int i = 0; i < 256; i++)
            bucket[i] = new ArrayList<>();
        // pass words[] && build bucket
        for (int i = 0; i < N; i++) {
            String word = words[i];
            bucket[word.charAt(0)].add(new Pair(i, 0));
        }
        // pass String s
        for (int i = 0; i < L; i++) {
            char c = s.charAt(i);
            ArrayList<pair> prevBucket = bucket[c];
            bucket[c] = new ArrayList<>();
            for (Pair pair : prevBucket) {
                int cur = pair.cur();
                int next = pair.next()+1;

            }
        }
    }
}
