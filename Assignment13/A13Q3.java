class ReverseKGroupsLinkedList {
  public ListNode reverseKGroup(ListNode head, int k) {
      if (head == null || k == 1) {
        return head;
      }
      ListNode dummy = new ListNode(0);
      dummy.next = head;
  
      ListNode start = dummy;
      ListNode end = head;
      int count = 0;
      while (end != null) {
        count++;
        // group
        if (count % k == 0) {
          // reverse linked list (start, end]
          start = reverse(start, end.next);
          end = start.next;
        } else {
          end = end.next;
        }
      }
      return dummy.next;
    }
    private ListNode reverse(ListNode start, ListNode end) {
      ListNode curr = start.next;
      ListNode prev = start;
      ListNode first = curr;
      while (curr != end){
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
      }
      start.next = prev;
      first.next = curr;
      return first;
    }
}