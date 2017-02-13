public class Solution {
    public void sortColors(int[] nums) {
        int i, r, w, b;  
        r = w = b = 0;  
        for (i = 0; i < nums.length; i++) {  
            if (nums[i] == 0) r++;  
            else  if (nums[i] == 1) w++;  
            else b++;  
        }  
        for (i = 0; i < nums.length; i++) {  
            if (i < r) nums[i] = 0;  
            else if (i < r + w) nums[i] = 1;  
            else nums[i] = 2;  
        }  
        
    }
}