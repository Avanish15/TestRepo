import java.util.Stack;
import java.util.HashMap;
public class PrintPath {

	/* Function to print root to leaf path for a leaf
	using parent nodes stored in map */
	public static void printTopToBottomPath(Node curr, HashMap<Node,Node> parent)
	{
		Stack<Node> stk=new Stack<>() ;

		// start from leaf node and keep on pushing
		// nodes into stack till root node is reached
		while (curr!=null)
		{
			stk.push(curr);
			curr = parent.get(curr);
		}

		// Start popping nodes from stack and print them
		while (!stk.isEmpty())
		{
			curr = stk.pop();
			System.out.print(curr.data+" ");
		}
		System.out.println();
	}


	/* An iterative function to do preorder traversal
	of binary tree and print root to leaf path
	without using recursion */
	public static void printRootToLeaf(Node root)
	{
		// Corner Case
		if (root == null)
			return;

		// Create an empty stack and push root to it
		Stack<Node> nodeStack=new Stack<>();
		nodeStack.push(root);

		// Create a map to store parent pointers of binary
		// tree nodes
		HashMap<Node,Node> parent=new HashMap<>();

		// parent of root is NULL
		parent.put(root,null);

		/* Pop all items one by one. Do following for
		every popped item
			a) push its right child and set its parent
			pointer
			b) push its left child and set its parent
			pointer
		Note that right child is pushed first so that
		left is processed first */
		while (!nodeStack.isEmpty())
		{
			// Pop the top item from stack
			Node current = nodeStack.pop();

			// If leaf node encountered, print Top To
			// Bottom path
			if (current.left==null && current.right==null)
				printTopToBottomPath(current, parent);

			// Push right & left children of the popped node
			// to stack. Also set their parent pointer in
			// the map
			if (current.right!=null)
			{
				parent.put(current.right,current);
				nodeStack.push(current.right);
			}
			if (current.left!=null)
			{
				parent.put(current.left,current);
				nodeStack.push(current.left);
			}
		}
	}


	public static void main(String args[]) {
		Node root=new Node(6);
		root.left = new Node(3);
		root.right = new Node(5);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.right.left = new Node(4);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
		printRootToLeaf(root);
	}
}

/* A binary tree node */
class Node
{
	int data;
	Node left, right;
	Node(int data)
	{
		left=right=null;
		this.data=data;
	}
};