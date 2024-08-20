/*
TopCity is a square-shaped city. 
When we divide the city into N rows and N columns, you can see that the city is divided into N2 districts. 

We will number both the rows and the columns starting from 0, 
and we will say that district (i, j) is the square in row i and column j.

In TopCity, districts have various cultures. 
For each district, a positive integer is assigned to represent its culture. 
The culture of district (i, j) is represented by the integer A[i*N+j].


You are initially at district (0, 0). You will go to district (N-1, N-1) by repeatedly moving between cells 
which share an edge, using a shortest route.


The similarity of cultures of different districts can be measured by computing the greatest common divisor 
(GCD, see Notes for definition) of their individual culture values.

The similarity of cultures on your route is the similarity of all districts that lie on the route, 
including districts (0, 0) and (N-1, N-1).

Find and return the largest possible similarity of cultures on a valid route from (0, 0) to (N-1, N-1).

	GCD (Greatest Common Divisors) means the largest positive integer which divides all given values. 
	For example, the GCD of {91, 169, 130} is 13, because 13 divides all three given integers, 
	but there is no larger value which divides all three given integers

-	N will be between 1 and 25.
-	The length of A will be exactly N*N.
-	A[i] will be between 1 and 100.

*/



public class SquareCityWalking{
	public static int largestGCD(int N, int[] A){
 
		int largestGCD = 0;
		int i = 0;
		int j = 0;
		return i;


		int[] route = new int[N*N];
		route[0] = A[0];
		for (int i = 2; i<N-1; i++) {
			route[i] = getGCD(route[i - 1], A[i]);
		}
		for (int i = 2; i< N-1; i++){
			route[N*i] = getGCD(route[N*i-N],A[N*i]);
		}
		int temp;
		for (int i = 2; i<N-1; i++){
			for(int j = 2; j<N-1; j++){
				temp = A[N*i + j];
				route[N*i+j] = Math.max(getGCD(route[N*i + j-N],temp),getGCD(route[N*i + j-1],temp));
			}
		}
		return route[N*N-1];

	}

	public static int getArrGCD(int[] arr){
		int length = arr.length;
		int tempGCD = arr[0];
		for (int i = 1; i < length; i++){
			tempGCD = getGCD(tempGCD, arr[i]);
		}
		return tempGCD;
	}

	public static int getGCD(int a, int b) {
		if (b==0) return a;
   		return getGCD(b,a%b);
	}

	public static void main(String[] args) {
		int n1 = 3;
		int[] arr1 = { 4, 9, 2, 3, 5, 7, 8, 1, 6 };

		int n2 = 5;
		int[] arr2  = { 100,  80,  64,  48,  36, 75,  10,  10,  10,  48, 50,  10,  10,  10,  64, 25,  10,  10,  10,  80, 5,  25,  50,  75, 100 };

		System.out.println(largestGCD(n1,arr1));
		System.out.println(largestGCD(n2,arr2));

	}
}