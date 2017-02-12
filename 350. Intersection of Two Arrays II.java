public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums1.length;i++)
            if(map.containsKey(nums1[i])==false)
                map.put(nums1[i],1);
            else
                map.put(nums1[i],1+map.get(nums1[i])); 
        List<Integer> resultList = new ArrayList<Integer>();
        for (int i=0;i<nums2.length;i++)
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i])>0){
                     resultList.add(nums2[i]);
                     map.put(nums2[i],-1+map.get(nums2[i])); 
                }
            }
        int result[] = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++)
            result[i]=resultList.get(i);
        return result;
    }
}