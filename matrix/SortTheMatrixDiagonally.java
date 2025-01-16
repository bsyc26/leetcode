// leetcode 1329
// matrix + hash + priority-queue:min-heap
// T: O(MNlog(min(M,N)) // M: mat.length, N: mat[0].length
// S: O(min(M,N))

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    /** Sort incr by diag of mat[][] */
    public int[][] diagonalSort(int[][] mat) {
        // const
        int M = mat.length;
        int N = mat[0].length;
        // var
        HashMap<Integer, PriorityQueue<Integer>> diags = new HashMap<>();
        // pass mat[][] && build diags
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                int curVal = mat[row][col];
                int diagID = row - col; // diag elems have the same row-col
                diags.putIfAbsent(diagID, new PriorityQueue<>());
                diags.get(diagID).add(curVal);
            }
        }
        // pass mat[][] && make sorted diag
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                int diagID = row - col;
                mat[row][col] = diags.get(diagID).poll(); // min-heap
            }
        }
        // return
        return mat;
    }
}
