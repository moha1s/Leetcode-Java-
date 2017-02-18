public class Solution {
public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;
        
        ListNode slow=head, fast=head;
        ListNode firsthalf = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondhalf = slow.next;
        slow.next = null;
        secondhalf = reverseOrder(secondhalf);
 
        while (secondhalf != null) {
            ListNode temp1 = firsthalf.next;
            ListNode temp2 = secondhalf.next;
 
            firsthalf.next = secondhalf;
            secondhalf.next = temp1;        
 
            firsthalf = temp1;
            secondhalf = temp2;
        }
        
    }
    
    ListNode reverseOrder(ListNode head) {
 
        if (head == null || head.next == null)
            return head;
 
        ListNode res=null,cur=null;
        while(head!=null){
            cur=head.next;
            head.next=res;
            res=head;
            head=cur;
          }
            return res;
    }
}