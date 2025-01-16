// leetcode 1352
// prefix:pre-prod
// T: O(1)
// S: O(N) // N: num of input num

//- get() without add:
//- add 0

class ProductOfNumbers {
    // field
    private ArrayList<Integer> preProd; // S: O(N)

    // constructor
    public ProductOfNumbers() { // T: O(1)
        preProd = new ArrayList<>(List.of(1)); // preProd[0] = 1
    }
    
    /** Appends num to stream */
    public void add(int num) { // T: O(1)
        if (num == 0) { // make all last k prod == 0, reset
            preProd.clear();
            preProd.add(1);
            return;
        } else {
            int size = preProd.size();
            int curProd = preProd.get(size-1);
            preProd.add(curProd * num);
        }
    }
    
    /** Returns the prod of last k num in curr list */
    public int getProduct(int k) { // T: O(1)
        int size = preProd.size();
        if (k > size-1) return 0;
        return preProd.get(size-1) / preProd.get(size-1-k);
    }
}
