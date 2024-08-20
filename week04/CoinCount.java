
public class CoinCount{
	// From Abeson and Sussman (Structure and Interpretation of Computer Programs)
	// • Problem: given a set of coins (5c, 10c, 20c, 50c, 100c, 200c) 
	// how many ways can we change a given amount of money e.g. $2.10?
	// • A solution can be defined recursively….
	
	//solution:
	// c(210, { 5,10,20,50,100,200 }) = c(210, { 10,20,50,100,200}) + c(205, { 5,10,20,50,100,200 });

	// boundary:
	// when a == 0c, there is only one way to change 0c;
	// when a <0; there is zero way;
	// when n == 0; there zre zero way to change any mount of money;

	private static int [] denoms = {5,10,20,50,100,200};

	public static int countChange(int amount){
		return countChange(amount,0);
	}

	public static int countChange(int amount, int denomPointer){
		if (amount == 0){
			return 1;
		}else if ( (amount < 0) || (denomPointer >= denoms.length) ){
			return 0;
		}else{
			return countChange(amount-denoms[denomPointer], denomPointer) +countChange(amount, ++denomPointer);
		}

	}

	public static void main(String[] args) {
		System.out.println(countChange(210));
	}

}