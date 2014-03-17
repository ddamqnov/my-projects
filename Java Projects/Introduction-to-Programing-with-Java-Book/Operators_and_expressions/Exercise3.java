package Operators_and_expressions;

/**
 * Created by Damqnov on 14-3-17.
 */

//Напишете израз, който да проверява дали дадено цяло число съдържа
//        7 за трета цифра (отдясно на ляво).


public class    Exercise3 {


    public static void main(String[] args) {
        System.out.println(checkNumber(23200));
    }

   static public boolean  checkNumber(int number){

      String temp = Integer.toString(number);
      String temp2 = String.valueOf(temp.charAt(temp.length()-3));

       if(temp2.equals("7")){
           return true;
       }
       else{
           return false;
       }

   }

}
