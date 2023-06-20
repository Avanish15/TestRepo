class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode prev = null;
        int n = 0;
        for (ListNode node = head, next; node != null; node = next) {
            next = node.next;
            node.next = prev;
            prev = node;
            n++;
        }
        int[] ans = new int[n], stack = new int[n];
        int top = 0;
        ListNode node = prev;
        for (int i = n - 1; i >= 0; i--) {
            while (top > 0 && stack[top - 1] <= node.val) {
                top--;
            }
            ans[i] = top > 0 ? stack[top - 1] : 0;
            stack[top++] = node.val;
            node = node.next;
        }
        return ans;
    }
}