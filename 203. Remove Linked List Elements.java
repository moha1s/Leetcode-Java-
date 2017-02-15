public class Solution {
    public ListNode removeElements(ListNode head, int val) {
       if(head==null) return head;    
       ListNode res=new ListNode(0);
       res.next=head;
       ListNode cur=res;
       
       
       while(head!=null){
           if(head.val==val) cur.next=head.next;
           else cur=cur.next;
           head=head.next;
       }
       return res.next;
    }
}