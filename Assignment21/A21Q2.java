import java.util.ArrayList;

public class Solution {

    /*
        Check if the subtree at 'root' contains the node with the given 'key' and 
        store the path from 'root' node to the node with the given 'key' in the array 'path'.
    */
    public static boolean pathFromRoot(BinaryTreeNode<Integer> root, ArrayList<Integer> path, int key) {
        if (root == null) {
            return false;
        }

        // Append the key at 'root' node to 'path'.
        path.add(root.data);

        // Check if 'root' node has the given 'key'.
        if (root.data == key) {
            return true;
        }

        /* 
            Try to find the node with the given 'key' is in the left or 
            right sub-tree of 'root' and update 'path' accordingly.
        */
        if (pathFromRoot(root.left, path, key) || pathFromRoot(root.right, path, key)) {
            return true;
        }

        /* 
            If the node with the given 'key' doesn't lie in the subtree
            at 'root', remove 'root' from the array 'path'.
        */
        path.remove(path.size() - 1);
        return false;
    }

    public static int distanceBetween2(BinaryTreeNode<Integer> root, int node1, int node2) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        // Store the path from 'root' to 'node1' in the array 'path1'.
        pathFromRoot(root, path1, node1);

        // Store the path from 'root' to 'node1' in the array 'path1'.
        pathFromRoot(root, path2, node2);

        int i = 0;

        // Compare 'path1' and 'path2' until we get the first different value.
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                // The node at postion 'i - 1' is the LCA of 'node1' and 'node2'.
                break;
            }
        }

        // Distance of 'node1' from LCA.
        int dist1 = path1.size() - i;

        // Distance of 'node2' from LCA.
        int dist2 = path2.size() - i;

        // Shortest distance between 'node1' and 'node2'.
        return dist1 + dist2;
    }
}