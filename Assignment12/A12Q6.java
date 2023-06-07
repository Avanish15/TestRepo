import java.util.*;

public class delete
{

static class Node
{
    int data;
    Node next;
};

static Node push( Node head_ref, int new_data)
{
        Node new_node = new Node();


    new_node.data = new_data;

    new_node.next = (head_ref);

    (head_ref) = new_node;
    
    return head_ref;
}

static void printList( Node head)
{
    Node temp = head;
    while (temp != null)
    {
        System.out.printf("%d ", temp.data);
        temp = temp.next;
    }
    System.out.printf("\n");
}

static void skipMdeleteN( Node head, int M, int N)
{
    Node curr = head, t;
    int count;

    while (curr!=null)
    {
        // Skip M nodes
        for (count = 1; count < M && curr != null; count++)
            curr = curr.next;

        if (curr == null)
            return;

        t = curr.next;
        for (count = 1; count <= N && t != null; count++)
        {
            Node temp = t;
            t = t.next;
        }

        curr.next = t;

        curr = t;
    }
}


public static void main(String args[])
{

    Node head = null;
    int M=2, N=2;
    head=push(head, 8);
    head=push(head, 7);
    head=push(head, 6);
    head=push(head, 5);
    head=push(head, 4);
    head=push(head, 3);
    head=push(head, 2);
    head=push(head, 1);
    System.out.printf("M = %d, N = %d \nGiven" +
                        "Linked list is :\n", M, N);
    printList(head);

    skipMdeleteN(head, M, N);

    System.out.printf("\nLinked list after deletion is :\n");
    printList(head);
}
}