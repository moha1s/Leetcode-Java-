public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode cur=slow.next;
        slow.next=null;
        while(cur!=null){
            ListNode n=cur.next;
            cur.next=slow;
            slow=cur;
            cur=n;
            
        }
        while(head!=null&&slow!=null){
            if(head.val==slow.val){
                head=head.next;
                slow=slow.next;
            }else return false;
        }
        return true;

    }
}