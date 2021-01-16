// calculate x^y
class PowerOfNum {
	public static void main(String[] args) {
		double x = 10.0;
		int y = 5;
		double result = powerOfNum(x, y);
		System.out.println(x + " to the power of " + y + " is " + result);
	}

	//x^y = (x^y/2)^2
	public static double powerOfNum(double x, int y) {
		double result = 1.0;
		int power = y;

		if (y < 0) {
			power = -power;
			x = 1.0/x;
		}

		while (power != 0) {
			if ((power & 1) != 0) {
				result *= x;
			}			
			x *= x;
			power >>>= 1;
		}

		return result;		
	}
}