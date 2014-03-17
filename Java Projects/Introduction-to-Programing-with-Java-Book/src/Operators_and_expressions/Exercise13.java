package Operators_and_expressions;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */

//Напишете програма, която проверява дали дадено число n (n < 100) е просто.


public class Exercise13 {


    public static void main(String[] args) {

        int n;


        Scanner in = new Scanner(System.in);
        System.out.println("Enter number: ");
        n = in.nextInt();
        if( n <= 0 ){
            System.out.println("The number must be positive !");
        }
        else{
            System.out.println(isPrime(n));
        }


    }

    static public boolean  isPrime(int n){


        for(int i = 2 ; i <  n/2 ; i++){
            if( n % i == 0){
                return false;
            }
       }

        return true;
    }

}
