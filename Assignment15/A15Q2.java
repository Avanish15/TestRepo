import java.util.ArrayList;

public class Solution{
    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

         // Iterating through all the array elements and finding next smaller element for each element.
   		 for (int i = 0; i < n; i++) {

       	 	// Initializing the next smaller element as -1.
        	ans.add(-1);

        	// Moving to the right of the element.
        	for (int j = i + 1; j < n; j++) {

            	// Checking for the next smaller element.
            	if (arr.get(i) > arr.get(j)) {
					ans.set(i, arr.get(j));
                	break;
            	}
        	}	
    	}

        return ans;
    }
}