

public class ShorterSuperSum{

	public static int calculate(int k, int n){

		if( k == 0){
			return n;
		}
		else
		{
			int sum  = 0;
			for(int i = 1; i<n+1; i++){
				sum += calculate(k-1,i);
			}
			return sum;
		}
	}


	public static void main(String[] args) {

		System.out.println(calculate(10,10));
		
	}
}