public class Arrows {

    public static int longestArrow(String s){
        int maxArrowLength= -1;
        int arrowLength = -1;

        int j;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '<'){
                arrowLength = 1;
                j = i;
                if (j < s.length()-1){
                    if (s.charAt(j+1) == '-'){
                        while(s.charAt(j+1) == '-'){
                            arrowLength += 1;
                            j += 1;
                            if (j == s.length())
                                break;
                        }
                    }else if (s.charAt(j+1) == '='){
                        while(s.charAt(j+1) == '='){
                            arrowLength += 1;
                            j += 1;
                            if (j == s.length())
                                break;
                        }
                    }
                }
            }

            if (s.charAt(i) == '>'){
                arrowLength = 1;
                j = i;

                if (j-1 > -1){
                    if (s.charAt(j-1) == '-'){
                        while(s.charAt(j-1) == '-'){
                            arrowLength += 1;
                            j -= 1;
                            if (j == 0)
                                break;
                        }
                    }else if (s.charAt(j-1) == '='){
                        while(s.charAt(j-1) == '='){
                            arrowLength += 1;
                            j -= 1;
                            if (j == 0)
                                break;
                        }
                    }
                }
            }

            if(arrowLength > maxArrowLength)
                maxArrowLength = arrowLength;

        }
        return maxArrowLength;
    }

    public static void main(String[] args) {
        String str1 = "<--->--==>";
        String str2 = "<<<<<<<<<<";
        String str3 = "----==-";
        String str4 = "<----=====>";

        System.out.println(longestArrow(str1));
        System.out.println(longestArrow(str2));
        System.out.println(longestArrow(str3));
        System.out.println(longestArrow(str4));

    }
}
