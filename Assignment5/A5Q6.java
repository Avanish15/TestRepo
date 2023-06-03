class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       int n = nums.length;
        int[] cs = new int[n+1];
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            cs[nums[i]] += 1;
        }
        for(int i = 0; i < cs.length; i++){
            if(cs[i] == 2){
                al.add(i);
            }
        }
        return al; 
    }
}