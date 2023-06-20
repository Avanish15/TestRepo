class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<2){
            return 0;
        }
        int c=0;
        for(int i=1;i<nums.length;i++){
        
            if(nums[i]-nums[i-1]>c){
                c=nums[i]-nums[i-1];
            }
        }
        return c;
        
    }
}