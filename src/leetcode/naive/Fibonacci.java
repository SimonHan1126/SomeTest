package leetcode.naive;

public class Fibonacci {
	
	public int fibonacci(int n) {
		// write your code here
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {	
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	
	public int fibonacci2(int n) {
		// write your code here
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			int temp1 = 0;
			int temp2 = 1;
			int sum = 0;
			for(int i = 3; i <= n; i++)
			{
				sum = temp1 + temp2;
				temp1 = temp2;
				temp2 = sum;
			}
			return sum;
		}
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacci2(47));
	}
}
