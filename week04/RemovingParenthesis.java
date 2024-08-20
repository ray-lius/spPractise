
public class RemovingParenthesis{

	/* 
	You are given a String s that is guaranteed to be a correct parentheses sequence. 
	A removal is an action that consists of two steps:

		Remove the first opening parenthesis in s.
		Remove one closing parenthesis in s. After you do so, s must again be a correct parentheses sequence.

	Compute and return the number of distinct ways in which s can be reduced to an empty string by performing consecutive removals. 
	Two ways are considered distinct if there is a step in which you remove a different closing parenthesis.
	*/
	public static int countWays(String s){

		if(s.equals(""))
		{
			return 1;
		}	
		else if(!isParenthesesSequences(s))
		{
			return 0;
		} 
		else 
		{
			int count = 0;

			for(int i = 0; i < s.length(); i++){

				if(s.charAt(i) == ')'){
					
					count += countWays(s.substring(1,i) + s.substring(i+1));
					
				}
			}

			return count;
		}	

		
	}

	/* 
	Correct parentheses sequences can be defined recursively as follows:

		The empty string "" is a correct sequence.
		If "X" and "Y" are correct sequences, then "XY" (the concatenation of X and Y) is a correct sequence.
		If "X" is a correct sequence, then "(X)" is a correct sequence.

	Each correct parentheses sequence can be derived using the above rules.
	Examples of correct parentheses sequences include "", "()", "()()()", "(()())", and "(((())))".
	*/

	public static boolean isParenthesesSequences(String s){

		//base case;
		if(s.equals(""))	return true;
		if( s.startsWith(")") || !s.contains("()") )	return false;

		// recursion;
		for(int i = 0; i < s.length()-1; i++){
			if ( (s.charAt(i) == '(') && (s.charAt(i+1) == ')') ){
				s = s.substring(0,i) + s.substring(i+2);
				break;
			}
		}

		return isParenthesesSequences(s);
	}

	public static void main(String[] args) {
		String s1 = "()()()()()";
		String s2 = "(((())))";
		String s3 = "((()()()))";
		String s4 = "(())(())(())";
		String s5 = "((()))(()(()))((()))";

		
		System.out.println(countWays(s5));
		
	
	}
}