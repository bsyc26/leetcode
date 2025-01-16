// leetcode 187
// hash:hash-set
// T: O(N) // N: s.length()
// S: O(N)

class Solution {                    
    /** Return all repeated 10-letter-long substr of s   
      * DNA seq: composed by 'A', 'C', 'G', 'T" */       
    public List<String> findRepeatedDnaSequences(String s) {
        // const                    
        int N = s.length();         
        // edge cases               
        if (s == null || N < 10) return new ArrayList<>();
        // res set                  
        HashSet<String> res = new HashSet<>();
        // vars                     
        HashSet<String> visited = new HashSet<>();
        // pass String s            
        for (int i = 0; i+10 <= N; i++) {
            String cur = s.substring(i, i+10);
            if (visited.contains(cur))
                res.add(cur);       
            else                    
                visited.add(cur);   
        }                           
        // return res               
        return new ArrayList<>(res);                                             
    }                               
}
