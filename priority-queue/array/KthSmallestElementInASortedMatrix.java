// leetcode 378
// priority-queue:min-heap
// T: O(NlogM) // N: matrix[0].length, M: matrix.length
// S: O(M)

/*
   sorted row -> comp each min of row -> min-heap
*/

//- empty matrix[][]: res set default value

import java.util.PriorityQueue;

class Solution {
    // nested record
    private record Tuple(int row, int col, int val) {}

    /** Return the kth smallest elems in maxtrix (rows and cols are sorted) */
    public int kthSmallest(int[][] matrix, int k) {
        // consts
        int M = matrix.length;
        int N = matrix[0].length;
        // res
        int kMinVal = Integer.MAX_VALUE;
        // vars
        PriorityQueue<Tuple> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val(), b.val())
        );
        for (int row = 0; row < M; row++)
            pq.offer(new Tuple(row, 0, matrix[row][0]));
        // pass pq
        while (!pq.isEmpty() && k > 0) {
            // poll
            Tuple cur = pq.poll();
            int curRow = cur.row();
            int curCol = cur.col();
            // update res
            kMinVal = cur.val();
            k--;
            // offer
            if (curCol + 1 < N)
                pq.offer(new Tuple(curRow, curCol+1, matrix[curRow][curCol+1]));
        }
        // return
        return (kMinVal == Integer.MAX_VALUE) ? -1 : kMinVal;
    }
}
