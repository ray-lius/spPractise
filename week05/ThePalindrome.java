

public class ThePalindrome{


	public static int find(String s){

		int length = s.length();
		int startPoint;

		if (length/2 != 0){
			startPoint = length/2 + 1;
			for(int i = startPoint; i < length; i++)
			{
				if( reverStr(s.substring(i-1-(length-1-i),i-1)).equals(s.substring(i)) || reverStr(s.substring(i-(length-i),i)).equals(s.substring(i)) ) // the i-(length-i);
				{
				 return length + (i-1-(length-1-i));
				}

			}
		}
		else
		{
			startPoint = length/2;
			for(int i = startPoint; i < length; i++)
			{
				if( reverStr(s.substring(i-(length-1-i),i)).equals(s.substring(i+1)) || reverStr(s.substring(i-(length-i),i)).equals(s.substring(i)) ) // the i-(length-i);
				{
				return length + (i-(length-1-i));
				}
			}
		}

		

		return 2*length -1;
		
	}

	public static String reverStr(String str){
		int length = str.length();
		String reverStr = "";
		for(int i = length-1; i >= 0; i--){
			reverStr += str.charAt(i);
		}
		return reverStr;
	}

	public static void main(String[] args) {
		String s = "abdfhdyrbdbsdfghjkllkjhgfds";
		String s1 = "abab";
		String s2 = "abacaba";
		String s3 = "qwerty";
		System.out.println(find(s));
	}
}