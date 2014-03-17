package Console_input_output;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */

//2. Напишете програма, която чете от конзолата радиуса "r" на кръг и отпечатва неговия периметър и обиколка.

public class Exercise2 {

    static Scanner in;

    public static void main(String[] args) {
        circleAttributes();
    }

    public static  void circleAttributes(){

        double r = 0;
        double temp;
        in = new Scanner(System.in);

        System.out.println("Enter radius : ");
        if((temp = in.nextDouble()) > 0 ){
            r = temp;
        }
        else{
            System.out.println("Invalid radius!");
        }


        double perimeter = 2 * Math.PI * r;
        double area = Math.PI * Math.pow(r,2);

        System.out.println("Area : " + area + " Perimeter: " + perimeter);

    }

}
