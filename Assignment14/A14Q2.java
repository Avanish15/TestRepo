public class Linked_List {
	static class Node {
		int data;
		Node next;
	}
	
	static Node newNode(int data)
	{
		Node temp_node = new Node();
		temp_node.data = data;
		temp_node.next = null;
		return temp_node;
	}

	//for reversing the linked list
	static Node reverseList(Node head)
	{
		Node previousNode = null;
		Node currentNode = head;
		Node next = null;
		while (currentNode != null) {
			next = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = next;
		}
		return previousNode;
	}

	static Node add1One(Node head)
	{
		Node result = head;
		Node temp = null, prev = null;

		int carry = 1, sum;

		while (head != null) 
		{
			sum = carry + head.data;

			carry = (sum >= 10) ? 1 : 0; //carry updation

			sum = sum % 10; //if greater than 10

			head.data = sum;

			temp = head;
			head = head.next;
		}

		if (carry > 0)
			temp.next = newNode(carry);

		return result;
	}

	static Node addOne(Node head)
	{
		head = reverseList(head); //for reversing the linked list
		head = add1One(head);
		return reverseList(head);
	}

	static void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.data);
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Node head = newNode(4);
		head.next = newNode(5);
		head.next.next = newNode(6);

		System.out.print("Previous List is: ");
		printList(head);

		head = addOne(head);
		System.out.print("New list is: ");
		printList(head);
	}
}