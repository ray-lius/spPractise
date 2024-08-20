import java.io.*; 
import java.util.List; 
import java.util.ArrayList; 

public class FamilyTravel{

	/*

	Characters 'a' to 'z' represent distances of 1 to 26, and characters 'A' to 'Z' represent distances of 27 to 52. 


	*/


	public static int shortest(String[] edges){

		int cityNum = edges.length;

		String[] paths = getPath(cityNum);

		int shortestLength = Integer.MAX_VALUE;
		int pathLength = 0;

		for(int i = 0; i<paths.length; i++){
			pathLength = getPathLength(edges, paths[i]);
			//System.out.println(pathLength);
			if( (pathLength != -1) && (pathLength < shortestLength) ){

				shortestLength = pathLength;
			}
		}

		if(shortestLength == Integer.MAX_VALUE)
			return -1;

		return shortestLength;
	}

	public static String[] getPath(int num){

		ArrayList<String> paths = new ArrayList<String>();

		paths.add("01");

		String path;
		String[] elements;
		String[] combination;
		if(num >= 3){

			elements = getElements(num);
			for(int i = 1; i<=elements.length ; i++){
				combination = getAllLists(elements, i);
				for(int j = 0; j < combination.length; j++){

					path = '0'+combination[j]+'1';
					paths.add(path);
				}

			}
		}

		String[] pathsCollection = new String[paths.size()];
		for(int i = 0; i<pathsCollection.length; i++){
			pathsCollection[i] = paths.get(i);
		}
		return pathsCollection;

	}

	public static String[] getElements(int num){

		String[] elements = new String[num-2];
		for(int i = 2; i<num; i++){
			elements[i-2] = String.valueOf(i);
		}
		return elements;
	}

	public static String[] getAllLists(String[] elements, int lengthOfList)
	{

    	if(lengthOfList == 1) return elements; 
    	else {
        //initialize our returned list with the number of elements calculated above
        	String[] allLists = new String[(int)Math.pow(elements.length, lengthOfList)];

        //the recursion--get all lists of length 3, length 2, all the way up to 1
        	String[] allSublists = getAllLists(elements, lengthOfList - 1);

        //append the sublists to each element
        	int arrayIndex = 0;

        	for(int i = 0; i < elements.length; i++){
            	for(int j = 0; j < allSublists.length; j++){
                //add the newly appended combination to the list
                	allLists[arrayIndex] = elements[i] + allSublists[j];
                	arrayIndex++;
            	}
        	}
        	return allLists;
    	}
	}

	public static int getPathLength(String[] edges, String path){

		int cityNum = path.length();
		int pathLength = 0;
		int interval = 0;
		int last_interval = Integer.MAX_VALUE;

		for(int i = 1; i<cityNum; i++){
			interval = interval( edges, Character.getNumericValue(path.charAt(i-1)), Character.getNumericValue(path.charAt(i)) );
			if(interval != -1){
				if( last_interval >= interval ){
					last_interval = interval;
					pathLength += interval;
				}else{
					return -1;
				}
				
			}else{
				return -1;
			}
			
		}

		return pathLength;
	}

	public static int interval(String[] edges, int i, int j){
		if( edges[i].charAt(j) >= 'a' && edges[i].charAt(j) <='z' )
			return edges[i].charAt(j)-'a'+1;
		if( edges[i].charAt(j) >= 'A' && edges[i].charAt(j) <='Z' )
			return edges[i].charAt(j)-'A'+27;

		return -1;
	}



	public static void main(String[] args) {
		String[] edges = {"00z00","0000a","z00bb","00b0b","0abb0"};
		System.out.println(shortest(edges));
	}

}