public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
         HashMap<RandomListNode,RandomListNode> res=new HashMap<>();
         RandomListNode cur=head;
         while(cur!=null){
             RandomListNode node=new RandomListNode(cur.label);
             res.put(cur,node);
             cur=cur.next;
         }
         cur=head;
         while(cur!=null){
             RandomListNode node=res.get(cur);
             node.next=res.get(cur.next);
             node.random=res.get(cur.random);
             cur=cur.next;
         }
         return res.get(head);
		 
	 
	 }
    
}