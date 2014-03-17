package Operators_and_expressions;

/**
 * Created by Damqnov on 14-3-17.
 */

//1. Напишете израз, който да проверява дали дадено цяло число е четно
//        или нечетно.

public class Exercise1 {

    public static void main(String[] args) {
        System.out.println(isEven(9));
    }

   static public boolean  isEven(int number){

        if(number % 2 == 0){
            return true;
        }
        else{

            return false;
        }
   }
}
