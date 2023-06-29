// Java Program to print the left view
import java.util.*;

class Solution {
	// Binary Tree Node
	static class Node {
		int data;
		Node left, right;

		public Node(int item)
		{
			data = item;
			left = right = null;
		}
	};
	// function to print the left view of binary tree
	public static ArrayList<Integer> leftView(Node root)
	{
		// Your code here
		ArrayList<Integer> ans = new ArrayList<>();

		if (root == null) {
			return ans;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		boolean ok = true;

		while (!q.isEmpty()) {
			Node it = q.poll();
			if (it == null) {
				if (ok == false) {
					ok = true;
				}

				if (q.size() == 0)
					break;

				else {
					q.add(null);
				}
			}
			else {

				if (ok) {
					ans.add(it.data);
					ok = false;
				}

				if (it.left != null) {
					q.add(it.left);
				}

				if (it.right != null) {
					q.add(it.right);
				}
			}
		}

		return ans;
	}
	// driver code
	public static void main(String[] args)
	{
		Node root = new Node(4);
		root.left = new Node(5);
		root.right = new Node(2);
		root.right.left = new Node(3);
		root.right.right = new Node(1);
		root.right.left.left = new Node(6);
		root.right.left.right = new Node(7);

		ArrayList<Integer> vec = leftView(root);
		for (int x : vec) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}