class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int arraySum = 0;
        int max_subarraySum = Integer.MIN_VALUE, temp_MAXSubarray=0;
        int min_subarraySun = Integer.MAX_VALUE, temp_MINSubarray=0;
        
        for(int num:nums)
        {
            arraySum +=num;

            temp_MAXSubarray += num;
            max_subarraySum = Math.max(max_subarraySum,temp_MAXSubarray);
            if(temp_MAXSubarray<0)
                temp_MAXSubarray = 0;

            temp_MINSubarray += num;
            min_subarraySun = Math.min(min_subarraySun,temp_MINSubarray);
            if(temp_MINSubarray>0)
                temp_MINSubarray = 0;
        }
        
        if(arraySum == min_subarraySun)
            return max_subarraySum;

        return Math.max(max_subarraySum,(arraySum-min_subarraySun));
    }
}