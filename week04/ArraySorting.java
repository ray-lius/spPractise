import java.util.Arrays;

public class ArraySorting{

	public static int[] arraySort(int[] A){


		for (int i = 0; i < A.length-1; i++){

			if(A[i] > A[i+1]){
				
				if (i == 0){
					A[i] = 1;
				}else{
					A[i+1] = A[i];	 
				}
			}
		}

		return A;

	}

	public static void main(String[] args) {
		
		int[] arr1 = { 10, 8 };
		int[] arr2 = { 6, 9 };
		int[] arr3 = { 9, 8, 10, 4 };
		int[] arr4 = { 3, 7, 7, 7, 6 };

		System.out.println(Arrays.toString(arraySort(arr1)));

	}
}