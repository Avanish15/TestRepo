class Max {
		public static void main(String[] args) {
			int a = 2;
			int d = 1;
			int n = 5;
			int b = 19;
			int s = 1;
			int m = 10;

			int nthTerm = a;
			int nthTerm1 = b;
			for (int i = 1; i < n; i++) {
				nthTerm += d;
				nthTerm1+=s;
			}
			System.out.println("The " + n + "th term of the series is: " + nthTerm);
			System.out.println("The " + m + "th term of the series is: " + nthTerm1);
		}
	}
