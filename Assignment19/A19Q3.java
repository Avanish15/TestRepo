class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public  void mergeSort(int[] nums,int start,int end){
        if(start<end){
            int mid=start+(end-start)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }
    public void merge(int[] nums,int start,int mid,int end){
        int[] arr1=Arrays.copyOfRange(nums,start,mid+1);
        int[] arr2=Arrays.copyOfRange(nums,mid+1,end+1);
        int i=0,j=0;
        int index=start;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                nums[index]=arr1[i];
                i++;
            }else{
                nums[index]=arr2[j];
                j++;
            }
            index++;    
        }
        while(i<arr1.length){
            nums[index]=arr1[i];
            i++;index++;
        }
        while(j<arr2.length){
            nums[index]=arr2[j];
            j++;index++;
        }
    }
}