package Operators_and_expressions;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */

//5. Напишете програма, която за подадени дължина и височина на
//        правоъгълник, изкарват на конзолата неговият периметър и лице.


public class Exercise5 {


    public static void main(String[] args) {

        double a;
        double b;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter first side: ");
        a = in.nextDouble();
        System.out.println("Enter second side: ");
        b = in.nextDouble();

        rectangle(a,b);

    }

   static public void  rectangle(double a, double b){

        double perimeter = 2*a + 2*b ;
        double area = a*b;

       System.out.println("Perimeter: " + perimeter + " Area: " + area);

   }

}
