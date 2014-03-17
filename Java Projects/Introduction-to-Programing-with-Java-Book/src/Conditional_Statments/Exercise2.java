package Conditional_Statments;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */
//2. Напишете програма, която показва знака (+ или -) от частното на две
//        реални числа, без да го пресмята.


public class Exercise2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x;
        int y;

        System.out.println("Enter number: ");
        x = in.nextInt();
        System.out.println("Enter number: ");
        y = in.nextInt();

        resultSign(x, y);

    }

    public static void resultSign(int x,int y){
        if( (x >  0 && y > 0) || ( x <  0 && y < 0)){
            System.out.print("+");
        }
        else{
            if( (x < 0 && y > 0 ) || (x > 0 && y < 0) ){
                System.out.print("-");
            }
            else{
                System.out.print("0");
            }
        }
    }
}


