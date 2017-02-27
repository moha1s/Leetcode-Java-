public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode pre=new ListNode(0);
        ListNode back=new ListNode(0);
        ListNode cur1=pre,cur2=back;
        while(head!=null){
            if(head.val<x){
                cur1.next=head;
                cur1=cur1.next;
            }else{
                cur2.next=head;
                cur2=cur2.next;
            }
            head=head.next;
        }
        cur2.next=null;
        cur1.next=back.next;
        return pre.next;
    }
}