class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0)
            return head;

        int length = 1;
        ListNode temp = head;

        while(temp.next != null) {
            length++;
            temp = temp.next;
        }

        temp.next = head;

        k = k % length;

        if(k == 0) {
            temp.next = null;
            return head;
        }

        int steps = length - k;

        while(steps-- > 1) {
            head = head.next;
        }

        ListNode ans = head.next;
        head.next = null;

        return ans;
    }
}