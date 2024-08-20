import java.util.Scanner;
public class DecodeString{

    private static String decodeString(String s){
        int re_num = 0;
        int digital_num = 0;
        int left_index = 0;
        int right_index = 0;
        int left_bracket_num = 0;
        int right_bracket_num = 0;

        if(s.length() == 0){
            return "";
        }else{
            int i = 0;
            while(i < s.length()){ // search digital num and the first "[" index;
                if(Character.isDigit(s.charAt(i))){
                    digital_num++;
                    re_num = re_num * 10 + Integer.parseInt(s.substring(i,i+1));// store the num for repetition;
                }
                if(s.substring(i, i+1).equals("[")){
                    left_index = i;
                    left_bracket_num++;
                    break;
                }
                if(i == (s.length() -1)){ //if we did not find "["in the last char, then it did not have to be decode;
                    return s;
                }
                i++;
            }
            while(i++ < s.length()){
                if(s.substring(i, i+1).equals("[")){
                    left_bracket_num++;
                }
                if(s.substring(i, i+1).equals("]")){
                    right_bracket_num++;
                }
                if(left_bracket_num == right_bracket_num){ // find the finish "]" index;
                    right_index = i;
                    break;
                }
            }
            String left_s = s.substring(0, (left_index-digital_num));// left-s is tag of front of repetition;
            String right_s = s.substring(right_index+1, s.length()); // right-tag of String need to be decode;
            String middle_s = s.substring(left_index+1, right_index);// middle -s need to be repeated;

            return  left_s + decodeString(middle_s).repeat(re_num) + decodeString(right_s);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "jk3[b2[ca]11[d]]xy";
        System.out.println("encoded string : " + s);
        System.out.println("original string : " + decodeString(s));

        System.out.print("Please input your string you want to decode: " );
        while(true){
            try{
                System.out.println("Your original string : " + decodeString(input.next()));
                break;
            }catch(Exception e){
                System.out.print("You input wrong type code, please re-input: ");
            }
        }
    }
}
