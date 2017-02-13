public class Solution {
    public int hIndex(int[] citations) {
       int res=0;
       if(citations==null) return res;
       Arrays.sort(citations);
       for(int i=citations.length-1;i>=0&&citations[i]>=(citations.length-i);i--){
           res=citations.length-i;
       }
       return res;
    
  }    
}