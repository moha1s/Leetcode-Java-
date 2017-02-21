public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null){
            TreeNode root = new TreeNode(head.val);
            return root;
        }
        ListNode slow=head,fast=head,pre=null;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        fast=slow.next;
        TreeNode root = new TreeNode(slow.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(fast);
        return root;
    }
}