package Ineuron;

public class Max{

	static int product(int ar[], int n)
	{
		int result = 1;
		for (int i = 0; i < n; i++)
			result = result * ar[i];
		return result;
	}
	
	// driver code for the above program
	public static void main(String[] args)
	{
		int ar[] = { 1, 2, 3, 4, 5 };
        int ar1[] = { 1, 6, 3 };
		int n = ar.length;
        int m = ar1.length;
		System.out.printf("%d", product(ar, n));
        System.out.printf("\n%d", product(ar1, m));
	}
}