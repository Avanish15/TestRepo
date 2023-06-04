class Power {

	public static void main(String[] args) {
	      
	    int base = 5, powerRaised = 2;
	    int base1 = 2, powerRaised1 = 5;
	    int result = power(base, powerRaised);
	    int result1 = power(base1, powerRaised1);

	    System.out.println(base + "^" + powerRaised + "=" + result);
	    System.out.println(base1 + "^" + powerRaised1 + "=" + result1);
	  }

	  public static int power(int base, int powerRaised) {
	    if (powerRaised != 0) {

	      // recursive call to power()
	      return (base * power(base, powerRaised - 1));
	    }
	    else {
	      return 1;
	    }
	  }
	}