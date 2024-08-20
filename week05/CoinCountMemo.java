import java.util.HashMap;

public class CoinCountMemo{

	private static int[] denoms = {5,10,20,50,100,200};
	private static HashMap store = new HashMap();

	public static int countChange(int amount){
		return countChange(amount,0);
	}

	public static int countChange(int amount, int denomPointer){

		String currParams = amount + " " + denomPointer;
		if(amount == 0){
			return 1;
		} else if ((amount < 0) || (denomPointer >= denoms.length)){
			return 0;
		}else if(store.containsKey(currParams)){
			return (Integer) store.get(currParams);
		}else {
			int result = countChange(amount-denoms[denomPointer], denomPointer) + countChange(amount, ++denomPointer);
			store.put(currParams,result);
			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(countChange(210));
	}

}