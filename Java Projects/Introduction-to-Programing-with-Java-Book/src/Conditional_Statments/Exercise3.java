package Conditional_Statments;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */
//3. Напишете програма, която намира най-голямото по стойност число,
//измежду три дадени числа.



public class Exercise3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x;
        int y;
        int z;

        System.out.println("Enter number: ");
        x = in.nextInt();
        System.out.println("Enter number: ");
        y = in.nextInt();
        System.out.println("Enter number: ");
        z = in.nextInt();

        System.out.println(findTheBiggestNumber(x, y, z));

    }

    public static int  findTheBiggestNumber(int x,int y,int z){
        int result = 0;

        if( x >= y && x >= z){
            result = x;
        }
        else{
            if( y >= z && y >= x){
                result = y;
            }
            else{
                if( z >= y && z >= z){
                    result =  z;
                }
            }
        }

        return result;
    }
}


