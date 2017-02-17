public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode res=new ListNode(0);
        ListNode pre=res,cur=head;
        while(cur!=null){
            pre=res;
            while(pre.next!=null&&pre.next.val<cur.val) pre=pre.next;
            ListNode next=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=next;
        }
        return res.next;
    }