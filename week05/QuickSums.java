import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuickSums{

	private static ArrayList<Integer> store = new ArrayList<Integer>();;

	public static int minSums(String numbers, int sum){

		store.clear();
		countSums(numbers,sum,0);

		if (store.isEmpty()){
			return -1;
		}else{
			return Collections.min(store);
		}
	}

	

	public static void countSums(String numbers, int sum, int plusNum){

		
		if( String.valueOf(sum).equals(numbers) ) 
		{
			//System.out.println("add inof" + plusNum);
			store.add(plusNum);
		} 
		else if( sum<0 || numbers.equals("") )
		{
			// empty for no action

		}else{

			int countSum = 0;
			plusNum += 1;
			for(int i = 1; i < numbers.length(); i++){
				//System.out.println(numbers.substring(i)+ " " + (sum-Integer.parseInt(numbers.substring(0,i))) + " " + plusNum);
				countSums(numbers.substring(i), sum-Integer.parseInt(numbers.substring(0,i)),plusNum);

			}

		}
	}
	public static void main(String[] args) {
		// for main function to check the function;
		String numbers = "0123456789";
		int sum = 45;
		System.out.println(minSums(numbers,sum));
	}



}