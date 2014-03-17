package Conditional_Statments;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */

//Напишете програма, която за дадена цифра (0-9), зададена като вход,
//        извежда името на цифрата на български език

public class Exercise6 {


    public static void main(String[] args) {

        Scanner in  = new Scanner(System.in);

        System.out.println("Enter a digit !");
        int temp = in.nextInt();
        if(temp >= 0 && temp < 10){
            System.out.println(translateDigit(temp));
        }

    }

    public static String translateDigit(int digit){

        String result = "";

        switch(digit){
            case 0: result = "Нула"; break;
            case 1: result = "Едно"; break;
            case 2: result = "Две"; break;
            case 3: result = "Три"; break;
            case 4: result = "Четири"; break;
            case 5: result = "Пет"; break;
            case 6: result = "Шест"; break;
            case 7: result = "Седем"; break;
            case 8: result = "Осем"; break;
            case 9: result = "Девет"; break;

        }

        return result;
    }
}
