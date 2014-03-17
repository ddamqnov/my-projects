package Operators_and_expressions;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */

//6. Напишете израз, който изчислява площта на трапец по дадени a, b и h.



public class Exercise6 {


    public static void main(String[] args) {

        double a;
        double b;
        double h;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter first side: ");
        a = in.nextDouble();
        System.out.println("Enter second side: ");
        b = in.nextDouble();
        System.out.println("Enter height: ");
        h = in.nextDouble();

        calculateArea(a,b,h);

    }

   static public void  calculateArea(double a, double b , double h){


        double area = (a + b) / 2 * h ;

       System.out.println(" Area: " + area);

   }

}
