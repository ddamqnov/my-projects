package Conditional_Statments;

/**
 * Created by Damqnov on 14-3-17.
 */
public class Exercise4 {

    public static void main(String[] args) {
        int array[] = {1,12,3,2,5,1,2,6};

        System.out.println(findMax(array));
    }

    public static int findMax(int array[]){

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < array.length ; i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        return max;
    }

}
