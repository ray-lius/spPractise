import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ProblemsToSolve{

	//  there is one soulution that, we cna find al soultion conbination
	// ans then calculatiuon all things return the minmum ways number;
	

	public static int minNumber(int[] pleasantness, int variety){
		int[] sortedPleas = new int[pleasantness.length];
		for(int i=0; i<pleasantness.length; i++){
			sortedPleas[i] = pleasantness[i];
		}
		Arrays.sort(sortedPleas);

		// System.out.println(Arrays.toString(pleasantness));

		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i< pleasantness.length; i++){
			for(int j = i+1; j< pleasantness.length; j++){
				if( (sortedPleas[j]-sortedPleas[i]) >= variety ){
					// System.out.println(sortedPleas[j] + " " + sortedPleas[i] );
					results.add(getSloveWays(pleasantness,sortedPleas[i],sortedPleas[j]));
				}
			}
		}

		// System.out.println(Arrays.toString(results.toArray()));

		if(results.isEmpty()){
			return pleasantness.length;
		}
		else{
			return Collections.min(results);
		}
		
	}


	// 
	public static int getSloveWays(int[] pleasantness, int mark_value_1, int mark_value_2){

		ArrayList<Integer> results = new ArrayList<Integer>();

		for(int i = 0; i< pleasantness.length; i++){
			for(int j = i+1; j< pleasantness.length; j++){
				if( (pleasantness[i] == mark_value_1) && (pleasantness[j] == mark_value_2) ){
					results.add(getMaxIntRes(i) + getMaxIntRes(j - i) + 1);
				}
				if( (pleasantness[i] == mark_value_2) && (pleasantness[j] == mark_value_1) ){
					results.add(getMaxIntRes(i) + getMaxIntRes(j - i) + 1);
				}
			}
		}

		return Collections.min(results);
	}

	public static int getMaxIntRes(int n){
		if (n%2 != 0)	return n/2 + 1;
		else 	return n/2;
	}
		

	public static void main(String[] args) {
		// int[] pleasantness = {6, 2, 6, 2, 6, 3, 3, 3, 7};
		// int variety = 4;

		// int[] pleasantness = {10,1};
		// int variety = 9;

		// int[] pleasantness = {10, 1, 12, 101};
		// int variety = 100;

		int[] pleasantness = {1, 2, 3, 4, 5};
		int variety = 4;

		System.out.println(minNumber(pleasantness, variety));
	}
		
}