
public class sumOfTwoIntegers 
{
	// Iterative
	public int getSum(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}

	// Iterative
	public static int getSubtract(int a, int b) {
		while (b != 0) {
			int borrow = (~a) & b;
			a = a ^ b;
			b = borrow << 1;
		}
		
		return a;
	}

	// Recursive
	public int getSum2(int a, int b) {
		return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
	}

	// Recursive
	public int getSubtract2(int a, int b) {
		return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
	}

	// Get negative number
	public int negate(int x) {
		return ~x + 1;
	}
	
	public static void main(String[] args)
	{
		 int a = 11, b = 22;
		 getSubtract(a,b);
	}
}