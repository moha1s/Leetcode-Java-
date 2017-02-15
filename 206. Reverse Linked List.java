public class Solution {
    public ListNode reverseList(ListNode head) {
     if(head==null||head.next==null) return head;
     ListNode cur1=null;
     ListNode cur2=null;
     while(head!=null){
         cur1=head.next;
         head.next=cur2;
         cur2=head;
         head=cur1;
        }
        return cur2;
    }
}