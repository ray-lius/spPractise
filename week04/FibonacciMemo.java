
public class FibonacciMemo{

	// Fibonacci[0] = 0
	// Fibonacci[1] = 1
	// Fibonacci[n] = Fibonacci[n - 2] + Fibonacci[n - 1]

	// Naturally, it would be better to only calculate that value once – 
	// and then remember that value so that it doesn’t need to be calculated again next time it is asked for. 
	// This is the basic idea of memoization. When we calculate an answer, 
	// we’ll store it in an array (named memo for this example) so we can reuse that answer later. 
	// When the function is called, we’ll first check to see if we’ve already got the answer stored in memo, 
	// and if we do we’ll return that value immediately instead of recalculating it

	public static int fib(int n){

		int[] memo = new int[n+1];
		for (int i = 0; i < n+1 ; i++)
			memo[i] = -1;

		// the base condition;
		memo[0] = 0;
		memo[1] = 1;

		return calcuFibonacci(n,memo);
	}

	public static int calcuFibonacci(int n, int[] memo){

		if (memo[n] != -1)	return memo[n];

		memo[n] = calcuFibonacci(n-1, memo) + calcuFibonacci(n-2, memo);

		return memo[n];
	}

	public static void main(String[] args) {
		System.out.println(fib(100));
	}

}