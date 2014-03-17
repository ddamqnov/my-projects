package Console_input_output;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */

//1. Напишете програма, която чете от конзолата три числа от тип int и отпечатва тяхната сума
public class Exercise1 {

    public static void main(String[] args) {
        int x;
        int y;
        int z;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter number:");
        x = in.nextInt();
        System.out.println("Enter number:");
        y = in.nextInt();
        System.out.println("Enter number:");
        z = in.nextInt();

        System.out.println("Result:" + (x+y+z));
    }

}
