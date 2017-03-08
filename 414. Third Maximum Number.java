public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> res=new PriorityQueue<>();
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(s.add(nums[i])){
                res.add(nums[i]);
            }
            if(res.size()>3) res.poll();
        }
        if(res.size()==2) res.poll();
        return res.peek();
    }
}