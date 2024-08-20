/* Problem Statement
    	
Bob is playing with his ball destroyer robot. Initially, Bob has r red balls, g green balls and b blue balls. 
The robot will repeat the following 3-step program until there are no balls left:

	If there is at least one red ball available, destroy one red ball.
	If there is at least one green ball available, destroy one green ball.
	If there is at least one blue ball available, destroy one blue ball.

You are given the longs r, g and b. You are also given a long k. 
Find the color of the k-th ball (1-index based) that will be destroyed.
	If the color of the k-th ball to be destroyed is red, return "RED" 
	(quotes for clarity, returned values are case-sensitive).
	If the color is green, return "GREEN".
	If the color is blue, return "BLUE".
*/


public class DestroyBall{
	public static String ballColor(long r, long g, long b, long k){

		// S1 :when one of r,g,b is not 0; the other two is 0;
		if (r > 0 && g==0 && b== 0)	return "RED";
		else if (r==0 && g > 0 && b == 0)	return "GREEN";
		else if (r==0 && g==0 && b > 0)	return "BLUE";
		

		// S2: when one of r,g,b is 0, the other two is not 0;
		else if (r>0 && g>0 && b == 0){
			long minRG = Math.min(r,g);
			if (k<= 2*minRG){
				if (k%2 == 1)	return "RED";
				else 	return "GREEN";
			}else{
				return ballColor(r-minRG, g-minRG, b, k-2*minRG);
			}
			
			
		} else if (r==0 && g>0 && b>0){
			long minGB = Math.min(g,b);
			if (k<= 2*minGB){
				if (k%2 == 1)	return "GREEN";
				else 	return "BLUE";
			}else{
				return ballColor(r, g-minGB, b-minGB, k-2*minGB);
			}

		} else if (r>0 && g==0 && b>0){
			long minRB = Math.min(r,b);
			if (k<= 2*minRB){
				if (k%2 == 1)	return "RED";
				else 	return "BLUE";
			}else{
				return ballColor(r-minRB, g, b-minRB, k-2*minRB);
			}

		}


		// s3: when r,g,b > 0; when if (r>0 && g>0 && b>0)
		else {
			long minRGB = Math.min(r,Math.min(g,b));

			if (k<=3*minRGB){
				switch((int)k%3) {
					case 1:	return "RED";
					case 2:	return "GREEN";
					case 0:	return "BLUE";
				}
			} else {
				return ballColor(r-minRGB, g-minRGB, b-minRGB, k-3*minRGB);
			}
		}

		return "ERROR k value";

	}

	public static void main(String[] args) {
		long r = 10000000;
		long g = 1;
		long b = 1;
		long k = 10000002;
		System.out.println(ballColor(r,g,b,k));

	}

}