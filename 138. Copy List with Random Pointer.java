//Method-1:
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
//Method-2:
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;  
          
        //第一遍扫描：对每个结点进行复制，把复制出来的新结点插在原结点之后  
        RandomListNode node = head;  
        while (node != null) {  
            RandomListNode newnode = new RandomListNode(node.label);  
            newnode.next = node.next;  
            node.next = newnode;  
            node = newnode.next;  
        }  
          
        //第二遍扫描：根据原结点的random，给新结点的random赋值  
        node = head;  
        while (node != null) {  
            if (node.random != null) node.next.random = node.random.next;  
            node = node.next.next;  
        }  
          
        RandomListNode newhead = head.next;  
          
        //第三遍扫描：把新结点从原链表中拆分出来  
        node = head;  
        while (node != null) {  
            RandomListNode newnode = node.next;  
            node.next = newnode.next;  
            if (newnode.next != null) newnode.next = newnode.next.next;  
            node = node.next;  
        }  
          
        return newhead;  
     
     }
    
}