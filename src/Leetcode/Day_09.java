package Leetcode;

/*
    Given the root of a binary tree, the depth of each node is the shortest
    distance to the root.

    Return the smallest subtree such that it contains all the deepest nodes in
    the original tree.

    A node is called the deepest if it has the largest depth possible among any
    node in the entire tree.

    The subtree of a node is a tree consisting of that node, plus the set of all
    descendants of that node.

    Input: root = [3,5,1,6,2,0,8,null,null,7,4]
    Output: [2,7,4]
    Explanation: We return the node with value 2, colored in yellow in the
    diagram.
    The nodes coloured in blue are the deepest nodes of the tree.
    Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node
    2 is the smallest subtree among them, so we return it.
*/

public class Day_09 {
    public static void main(String[] args) {

    }
    public Result dfs(TreeNode root){
        if(root==null) return new Result(null, 0);

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if(left.dist>right.dist){
            return new Result(left.node, left.dist+1);
        }else if(right.dist>left.dist){
            return new Result(right.node, right.dist+1);
        }else{
            return new Result(root, left.dist+1);
        }
    }

    class Result{
        int dist;
        TreeNode node;

        Result(TreeNode node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
