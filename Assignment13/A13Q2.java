import java.util.HashSet;

// Definition for singly-linked list
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class Solution {
	// Function to remove duplicates from a sorted linked
	// list
	public ListNode deleteDuplicates(ListNode head)
	{
		// Return head if it's null
		if (head == null)
			return head;

		// Use a HashSet to store unique values in the
		// linked list
		HashSet<Integer> set = new HashSet<>();
		ListNode prev
			= head; // Keep track of the previous node
		ListNode curr = head.next; // Pointer to traverse
								// the linked list

		// Add the first node to the set
		set.add(head.val);

		// Iterate through the linked list
		while (curr != null) {
			// If the current value already exists in set,
			// remove the node
			if (set.contains(curr.val)) {
				prev.next = curr.next;
			}
			else {
				// Otherwise, add the value to set and move
				// on to the next node
				set.add(curr.val);
				prev = curr;
			}
			curr = curr.next;
		}

		// Return the head of the linked list
		return head;
	}
}

public class Main {
	public static void main(String[] args)
	{
		// Initialize linked list with values 1, 2, 2, 3
		ListNode head = new ListNode(11);
		head.next = new ListNode(11);
		head.next.next = new ListNode(11);
		head.next.next.next = new ListNode(21);
		head.next.next.next.next = new ListNode(43);
		head.next.next.next.next.next = new ListNode(43);
		head.next.next.next.next.next.next
			= new ListNode(60);

		Solution solution = new Solution();
		ListNode Beforeprinter = head;
		System.out.print(
			"before removing the duplicates linked list is:");
		while (Beforeprinter != null) {
			System.out.print(Beforeprinter.val + " ");
			Beforeprinter = Beforeprinter.next;
		}
		System.out.println();
		// Remove duplicates from the linked list using the
		// deleteDuplicates function
		head = solution.deleteDuplicates(head);

		// Print the linked list after removing duplicates
		System.out.print(
			"after removing the duplicates linked list is:");
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}