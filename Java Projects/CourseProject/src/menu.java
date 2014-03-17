/**
 * Created by Damqnov on 14-1-21.
 */
import java.util.Scanner;
public class menu{
    public void getUserChoice(){
        System.out.println("Please enter menu number:");
        Scanner in = new Scanner(System.in);
        int temp = in.nextInt();
        Utilities ut = new Utilities();
        GetData gd = new GetData();
        switch(temp){
            case 1:
                ut.addCompanyPlane(gd.gettingPlaneInformation());
                break;

            case 2:
                ut.addDestination(gd.gettingDestinationInformation());
                break;

            case 3:
                ut.showAllAirplanes();
                break;

            case 4:
                ut.showAllDestinations();
                break;
            case 5:
                ut.findCompatiblePlain(gd.gettingDestinationName());
                break;

            case 6:
                System.exit(1);
                break;
        }

        showMenu();


    }

    public void showMenu(){
        System.out.println("**************************************************************");
        System.out.println("*     1. Add Airplane                                        *");
        System.out.println("*     2. Add Destination                                     *");
        System.out.println("*     3. Show all Airplanes                                  *");
        System.out.println("*     4. Show all Destinations                               *");
        System.out.println("*     5. Find compatible plane for destination               *");
        System.out.println("*     6. Exit                                                *");
        System.out.println("**************************************************************");

        getUserChoice();
    }
}
