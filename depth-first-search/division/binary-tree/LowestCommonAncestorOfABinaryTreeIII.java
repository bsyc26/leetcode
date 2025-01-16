// leetcode 1650
// dfs:division
// T: O(N) // N: num of nodes of binary tree
// S: O(H) // H: height of binary tree // call-stack

class Solution {
    /** Return the LCA of p and q, p != q, both exist, all vals are uniq */
    public Node lowestCommonAncestor(Node p, Node q) {
        // find root
        Node root = p;
        while (root.parent != null)
            root = root.parent;
        // dfs:division
        return dfs(root, p, q);
    }

    /** Return the LCA of p and q */
    private Node dfs(Node node, Node p, Node q) {
        // base case
        if (node == null)
            return null;
        // pre order
        if (node == p || node == q) // is p or q
            return node;
        // division
        Node left = dfs(node.left, p, q);
        Node right = dfs(node.right, p, q);
        // post order
        if (left != null && right != null) // is LCA
            return node;
        return (left != null) ? left : right;
    }
}

// follow-up
// T: O(logN)
// S: O(1)
