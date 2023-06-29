import java .io.*;

class Solution
{
	// function to return max
	// of left subtree height
	// or right subtree height
	static int findDepthRec(String tree,
							int n, int index)
	{
		if (index >= n ||
			tree.charAt(index) == 'l')
			return 0;

		// calc height of left subtree
		// (In preorder left subtree
		// is processed before right)
		index++;
		int left = findDepthRec(tree,
								n, index);

		// calc height of
		// right subtree
		index++;
		int right = findDepthRec(tree, n, index);

		return Math.max(left, right) + 1;
	}

	// Wrapper over findDepthRec()
	static int findDepth(String tree,
						int n)
	{
		int index = 0;
		return (findDepthRec(tree,
							n, index));
	}

	// Driver Code
	static public void main(String[] args)
	{
		String tree = "nlnnlll";
		int n = tree.length();
		System.out.println(findDepth(tree, n));
	}
}