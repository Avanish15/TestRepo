package Ineuron;

import java.util.*;

class Solution {
	static void powerSet(String str, int index, String curr)
	{
		int n = str.length();

		// base case
		if (index == n) {
			return;
		}

		// First print current subset
		System.out.println(curr);

		// Try appending remaining characters
		// to current subset
		for (int i = index + 1; i < n; i++) {
			curr += str.charAt(i);
			powerSet(str, i, curr);

			// Once all subsets beginning with
			// initial "curr" are printed, remove
			// last character to consider a different
			// prefix of subsets.
			curr = curr.substring(0, curr.length() - 1);
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		String str = "abcd";
		int index = -1;
		String curr = "";
		powerSet(str, index, curr);
	}
}