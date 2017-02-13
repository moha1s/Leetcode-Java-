public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int n=intervals.size();
        int[] start=new int[n];
        int[] end=new int[n];
        for(int i=0;i<n;i++){
            start[i]=intervals.get(i).start;
            end[i]=intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> res=new LinkedList<Interval>();
        for(int i=0,j=0;i<n;i++){
            if(i==n-1||start[i+1]>end[i]){
                res.add(new Interval(start[j],end[i]));
                j=i+1;
            }
        }
        return res;
    }
}