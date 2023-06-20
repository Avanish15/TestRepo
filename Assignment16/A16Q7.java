// Java program to remove consecutive same words

import java.util.Vector;

class Test
{
	// Method to find the size of manipulated sequence
	static int removeConsecutiveSame(Vector <String > v)
	{
		int n = v.size();
	
		// Start traversing the sequence
		for (int i=0; i<n-1; )
		{
			// Compare the current string with next one
			// Erase both if equal
			if (v.get(i).equals(v.get(i+1)))
			{
				// Erase function delete the element and
				// also shifts other element that's why
				// i is not updated
				v.remove(i);
				v.remove(i);
	
				// Update i, as to check from previous
				// element again
				if (i > 0)
					i--;
	
				// Reduce sequence size
				n = n-2;
			}
	
			// Increment i, if not equal
			else
				i++;
		}
	
		// Return modified size
		return v.size();
	}
	
	// Driver method
	public static void main(String[] args)
	{
		Vector<String> v = new Vector<>();

		v.addElement("tom"); v.addElement("jerry");
		v.addElement("jerry");v.addElement("tom");
        Vector<String> v1 = new Vector<>();
         
        v1.addElement("ab"); v1.addElement("aa");
        v1.addElement("aa"); v1.addElement("bcd");
        v1.addElement("ab");
         
        System.out.println(removeConsecutiveSame(v));

		System.out.println(removeConsecutiveSame(v1));
	}
}