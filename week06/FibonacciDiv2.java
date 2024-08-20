
public class FibonacciDiv2 {

	public static int find(int N){

		int i = 0;

		while(N >= fib(i)){
			i = i+1;
		}

		return Math.min(fib(i) - N, N-fib(i-1));

	}

	public static int fib(int n){

		// base case
		if( n ==0 || n == 1){
			return n;
		}

		int[] memo = new int[n+1];
		for (int i = 0; i < n+1 ; i++){
			memo[i] = -1;
		}

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

		System.out.println(find(1000000));
		
	}
	
}