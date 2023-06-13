class Solution
{
static class Node
{
	int key;
	Node next;
};

static Node deleteLast(Node head, int key)
{

	Node x = null;

	Node temp = head;
	while (temp != null)
	{
		// If we found the key, update xv
		if (temp.key == key)
			x = temp;

		temp = temp.next;
	}

	if (x != null)
	{


		x.key = x.next.key;

		temp = x.next;
		x.next = x.next.next;

	}
	return head;
}

static Node newNode(int key)
{
	Node temp = new Node();
	temp.key = key;
	temp.next = null;
	return temp;
}

static void printList( Node node)
{
	while (node != null)
	{
		System.out.printf(" %d ", node.key);
		node = node.next;
	}
}

public static void main(String args[])
{
	Node head = newNode(1);
	head.next = newNode(2);
	head.next.next = newNode(3);
	head.next.next.next = newNode(5);
	head.next.next.next.next = newNode(2);
	head.next.next.next.next.next = newNode(10);

	System.out.printf("Created Linked List: ");
	printList(head);
	deleteLast(head, 2);
	System.out.printf("\nLinked List after Deletion of 2: ");
	printList(head);
}
}