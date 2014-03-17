package Operators_and_expressions;

/**
 * Created by Damqnov on 14-3-17.
 */

// Напишете булев израз, който да проверява дали дадено цяло число се
//        дели на 5 и на 7 без остатък.


public class Exercise2 {

    public static void main(String[] args) {
        System.out.println(checkNumber(35));
    }

   static public boolean  checkNumber(int number){

        if(number % 5 == 0 && number % 7 == 0){
            return true;
        }
        else{
            return false;
        }
   }
}
