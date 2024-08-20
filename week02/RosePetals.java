

public class RosePetals {
            //"Petals Around the Rose" is a pretty well known logic game.
            // We will simply tell you that the rule is to sum the number of dots that are around the center dot of each die,
            // like the petals around a rose.
            // If a die has no dot in the center, it has no petals.
            // The face of the die labeled with 1 dot has 0 petals, the face with 2 dots has 0 petals,
            // the face with 3 dots has 2 petals, the face with 4 dots has 0 petals,
            // the face with 5 dots has 4 petals and finally the face with 6 dots has 0 petals as can be seen in the picture.
            // You are given a int[] dice containing the values of the five dice. Return the total number of petals in this configuration.

    public static int getScore(int[] dices){
        int score = 0;
        for(int dice : dices){
            if(dice == 3){
                score += 2;
            }else if(dice == 5){
                score += 4;
            }
        }
        return score;
    }

    // main function for testing;
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 1};
        int[] arr2 = {4, 4, 5, 6, 5};
        int[] arr3 = {3, 3, 3, 3, 3};


        System.out.println(getScore(arr1));
        System.out.println(getScore(arr2));
        System.out.println(getScore(arr3));

    }
}
