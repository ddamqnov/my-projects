package Conditional_Statments;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */


// Да се напише if-конструкция, която изчислява стойността на две
//целочислени променливи и разменя техните стойности, ако стойността
//на първата променлива е по-голяма от втората.

public class Exercise1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x;
        int y;

        System.out.println("Enter number: ");
        x = in.nextInt();
        System.out.println("Enter number: ");
        y = in.nextInt();
        System.out.println("x: " +x + " y:" + y );


        compare(x,y);

    }

    public static void compare(int x,int y){
        if(x > y){
            int temp = x;
            x = y;
            y = temp;

            System.out.println("x: " + x + " y:" + y );
        }
    }

}
