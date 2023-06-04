package Ineuron;

import java.io.*;

class Solution {

	// Function to check for consonant
	static boolean isConsonant(char ch)
	{
		// To handle lower case
		ch = Character.toUpperCase(ch);
	
		return !(ch == 'A' || ch == 'E' ||
				ch == 'I' || ch == 'O' ||
				ch == 'U') && ch >= 65 && ch <= 90;
	}

	static int totalConsonants(String str)
	{
		int count = 0;
		for (int i = 0; i < str.length(); i++)
	
			// To check is character is Consonant
			if (isConsonant(str.charAt(i)))
				++count;
		return count;
	}
	
	// Driver code
	public static void main(String args[])
	{
		String str = "abc de";
        String str1 = "geeksforgeeks portal";
		System.out.println( totalConsonants(str));
        System.out.println( totalConsonants(str1));
	}
}