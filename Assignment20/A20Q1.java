import java.util.*;
class Solution
{

// Structure of a tree node.
static class Node
{
	int key;
	Node left, right;
}

static class INT
{
	int v;
	INT(int a)
	{
		v = a;
	}
}

// Function to create new tree node.
static Node newNode(int key)
{
	Node temp = new Node();
	temp.key = key;
	temp.left = temp.right = null;
	return temp;
}

// Helper function to find largest
// subtree sum recursively.
static int findLargestSubtreeSumUtil(Node root,
									INT ans)
{
	// If current node is null then
	// return 0 to parent node.
	if (root == null)	
		return 0;
	
	// Subtree sum rooted
	// at current node.
	int currSum = root.key +
	findLargestSubtreeSumUtil(root.left, ans) +
	findLargestSubtreeSumUtil(root.right, ans);

	// Update answer if current subtree
	// sum is greater than answer so far.
	ans.v = Math.max(ans.v, currSum);

	// Return current subtree
	// sum to its parent node.
	return currSum;
}

// Function to find
// largest subtree sum.
static int findLargestSubtreeSum(Node root)
{
	// If tree does not exist,
	// then answer is 0.
	if (root == null)	
		return 0;
	
	// Variable to store
	// maximum subtree sum.
	INT ans = new INT(-9999999);

	// Call to recursive function
	// to find maximum subtree sum.
	findLargestSubtreeSumUtil(root, ans);

	return ans.v;
}

// Driver Code
public static void main(String args[])
{
	/*
			1
			/ \
			/	 \
		-2	 3
		/ \	 / \
		/ \ / \
		4	 5 -6	 2
	*/

	Node root = newNode(1);
	root.left = newNode(-2);
	root.right = newNode(3);
	root.left.left = newNode(4);
	root.left.right = newNode(5);
	root.right.left = newNode(-6);
	root.right.right = newNode(2);

	System.out.println(findLargestSubtreeSum(root));
}
}