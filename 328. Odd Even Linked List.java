public class Solution {
    public ListNode oddEvenList(ListNode head) {
       if(head==null) return head;
       ListNode odd=head,even=head.next,res=even;
       while(even!=null&&even.next!=null){
           odd.next=even.next;
           odd=odd.next;
           even.next=odd.next;
           even=even.next;
       }
       odd.next=res;
       return head;
        
    }
}