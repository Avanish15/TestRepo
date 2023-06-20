// Binary Search
// TC -> O(nlogn)
// SC -> O(n)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i=1;i<n;i++){
            if(nums[i]>list.get(list.size()-1))
                list.add(nums[i]);
            else
                list.set(upperBound(list,nums[i]),nums[i]);
        }
        return list.size();
    }

    private int upperBound(ArrayList<Integer> list,int target){
        int i=0, j=list.size()-1;
        while(i<=j){
            int mid = (i+j)/2;

            if(list.get(mid)<=target){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return list.get(Math.max(j,0)) == target? j:i; // return last targetIndex | insertionIndex
    }
}