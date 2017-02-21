public class Solution {
    public ListNode detectCycle(ListNode head) {
    if(head==null||head.next==null) return head;
    ListNode slow = head, fast = head;
	while(fast != null && fast.next != null) {
		fast = fast.next.next;
		slow = slow.next;
		if (slow == fast) {
			while (head != slow) {
				head = head.next;
				slow = slow.next;
			}
			return slow;				
		}
	}			
	return null;
    }
}