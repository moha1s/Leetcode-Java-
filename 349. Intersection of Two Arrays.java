public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> tmp = new HashSet<>();
        for(int n:nums1) tmp.add(n);
        List<Integer> res = new ArrayList<>();
        for(int n:nums2)
            if(tmp.remove(n))
                res.add(n);
        int[] rr = new int[res.size()];
        for(int i=0;i<res.size();i++) rr[i] = res.get(i);
        return rr;
        
    }
}