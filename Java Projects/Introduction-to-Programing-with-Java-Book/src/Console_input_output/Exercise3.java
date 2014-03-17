package Console_input_output;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */

// Напишете програма, която чете от конзолата две цели числа (integer)
// и отпечатва, колко числа има между тях, такива, че остатъкът им от
//        деленето на 5 да е 0.

public class Exercise3 {

    public static void main(String[] args) {
        calculate();
    }

    public static void calculate(){

        int x;
        int y;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the first number");
        x = in.nextInt();
        System.out.println("Enter the second number");
        y = in.nextInt();

        for(int i = x ; i < y ; i++){
            if(i % 5 == 0 ){
                System.out.println(i);
            }
        }

    }
}
