class Solution {
    public int[] intersection(int[] arr1, int[] arr2) {
        // 1. Iterate over the first array
        Set<Integer> set1 = new HashSet<>();
        for (int i : arr1) {
            set1.add(i);
        }

        // 2. Iterate over the second array
        Set<Integer> commonElements = new HashSet<>();
        for (int i : arr2) {
            // does this element exist in the first array?
            if (set1.contains(i)) {
                commonElements.add(i);
            }
        }

        // 3. Prepare the result array
        int[] res = new int[commonElements.size()];
        int idx = 0;
        for (int e : commonElements) {
            res[idx++] = e;
        }
        return res;
    }
}