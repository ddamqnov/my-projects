package Primitive_Types_and_Variables;

/**
 * Created by Damqnov on 14-3-17.
 */

//10. Декларирайте две променливи от тип int. Задайте им стойности
//        съответно 5 и 10. Разменете стойностите им и ги отпечатайте.



public class Exercise10 {



    public static void main(String[] args) {

       int x = 5;
       int y = 10;
       int temp;

        temp = x;
        x = y;
        y = temp;

        System.out.println("x: " + x + " y: " + y);

    }

}
