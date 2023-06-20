class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            final int v = nums[i];
            if (v < min) {
                min = v;
            } else if (v > max) {
                max = v;
            }
        }
        final int delta = -min + 1;
        final int[] arr = new int[max + delta + 1];
        final int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            final int v = nums[i] + delta;
            res[i] = get(arr, v - 1);
            add(arr, v);
        }
        return new java.util.AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return res[index];
            }
            @Override
            public int size() {
                return res.length;
            }
        };
    }
    static int get(final int[] arr, int v) {
        int sum = 0;
        for (; v > 0; v -= v & -v)
            sum += arr[v];
        return sum;
    }
    static void add(final int[] arr, int v) {
        for (; v < arr.length; v += v & -v)
            arr[v]++;
    }
}