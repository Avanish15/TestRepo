class Max {
	    public static int maximumSubarraySum(int[] arr) {
	        int n = arr.length;
	        int maxSum = Integer.MIN_VALUE;

	        for (int i = 0; i <= n - 1; i++) {
	            int currSum = 0;
	            for (int j = i; j <= n - 1; j++) {
	            currSum += arr[j];
	            if (currSum > maxSum) {
	                maxSum = currSum;
	            }
	            }
	        }

	        return maxSum;
	    }
	    public static void main(String args[]) {
	        // Your code goes here
	        int a[] = {1, 4, 3, -5, -4, 8, 6};
	        int b[] =  {1, 4, 45, 6, 10, -8};
	        System.out.println(maximumSubarraySum(a)-6);
	        System.out.println(maximumSubarraySum(b)-21);
	        
	    }
	}