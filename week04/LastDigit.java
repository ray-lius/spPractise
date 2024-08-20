public class LastDigit{

	// Limak chose a positive integer X and wrote it on a blackboard. 
	//After that, every day he erased the last digit of the current number. 
	//He stopped when he erased all digits.

	//After the process was over, Limak computed the sum of all numbers that appeared on the blackboard, 
	//including the original number X.

	// For example, if the original number was 509, 
	//the numbers that appeared on the blackboard were the numbers 509, 50, and 5. Their sum is 564.

	//You are given a long S. 
	//Limak wants you to find a number X such that the above process produces the sum S. 
	//It can be shown that for any positive S there is at most one valid X. 
	//If there is a valid X, find and return it. Otherwise, return -1.


	// S = X+X/10+X/100,  so X*1.11111< S < X*1.111 + 1*(digits-1)
	// so X > (s-digits+1)/1.111 and X< S/1.1111;

	public static long findX(long S){

		int digitNum = countDigits(S);

		double index = 0;// index for counting;
		for(int i = 0; i < digitNum; i++){
			index = index + Math.pow(0.1,i);
		}
		long minValue = (long)(S/index);
		long maxValue = (long)(S/index)+digitNum-1;

		System.out.println(digitNum + " " + index + " " + minValue + " " + maxValue);

		for(long i = minValue; i <= maxValue; i++){
			if(getSum(i) == S)
				return i;
		}

		return -1;
	}
	
	// count the Number digits numbers;
	public static int countDigits(long S){
		if(S/10 == 0)	return 1;
		else 	return 1+countDigits(S/10);
	}
	
	// method to get Sum;
	public static long getSum(long X){

		if ( X/10 == 0)	return X;
		else return X + getSum(X/10);
	}

	public static void main(String[] args) {
		long S1 = 564;
		long S2 = 565;
		long S3 = 3000;
		long S4 = 137174210616796L;
		long S5 = 837592744927492746L;
		long S6 = 999999999999999999L;

		System.out.println(getSum(123456789555123L));
		System.out.println(findX(S1));
	}
 
}


