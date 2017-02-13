public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       if(head==null||head.next==null) return head;
       ListNode res=head;
       while(res.next!=null){
           if(res.val==res.next.val){
           res.next=res.next.next;
           }else res=res.next;
       }
       
       return head;
        
    }
}