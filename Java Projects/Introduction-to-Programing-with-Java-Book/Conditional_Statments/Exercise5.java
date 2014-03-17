package Conditional_Statments;

import java.util.Scanner;

/**
 * Created by Damqnov on 14-3-17.
 */

//Напишете програма, която прилага бонус точки към дадени точки в
//        интервала [1..9] чрез прилагане на следните правила:
//        - Ако точките са между 1 и 3, програмата ги умножава по 10.
//        - Ако точките са между 4 и 6, ги умножава по 100.
//        - Ако точките са между 7 и 9, ги умножава по 1000.
//        - Ако точките са 0 или повече от 9, се отпечатва съобщение за
//        грешка


public class Exercise5 {

    static int points = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the points value: ");
        points = in.nextInt();


        addBonus();

        System.out.println("Points + bonus : " + points);

    }

    public static void addBonus(){
        if(points == 0 || points > 9){
           System.out.println("The points must be in range 1 - 9 !");
        }
        else{
            if(points >= 1 && points <= 3){
                points *= 10;
            }
            else{
                if(points >= 4 && points <= 6){
                    points *= 100;
                }
                else{
                    if(points >= 7   && points <= 9){
                        points *= 1000;
                    }

                }
            }
        }
    }
}