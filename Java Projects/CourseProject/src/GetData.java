/**
 * Created by Damqnov on 14-1-21.
 */
import java.io.IOException;
import java.util.Scanner;
public class GetData implements IGetData{
   public static Scanner in;
    @Override
    public CompanyPlane gettingPlaneInformation() {
        in = new Scanner(System.in);
        CompanyPlane temp = new CompanyPlane();
        PlaneExpenses pe = new PlaneExpenses();
        System.out.println("Please add airplane data: ");
        System.out.println("Enter id:");
        temp.setPlaneId(in.nextInt());
        in.nextLine();
        System.out.println("Enter producer: ");
        try {
            temp.setProducer(in.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Enter model:");
        try {
            temp.setModel(in.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Enter number of seats:");
        try {
            temp.setSeatsNumber(in.nextInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.nextLine();
        System.out.println("Enter landing path distance:");
        try {
            temp.setLandingSpace(in.nextDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.nextLine();
        System.out.println("Enter personal expenses:");
        pe.setPersonalExpenses(in.nextDouble());
        System.out.println("Enter average speed:");
        pe.setAverageSpeed(in.nextInt());
        in.nextLine();
        System.out.println("Enter tank size:");
        pe.setTankSizeInLiters(in.nextInt());
        in.nextLine();
        System.out.println("Enter fuel per KM:");
        pe.setLittersPerKM(in.nextInt());
        temp.setExpenses(pe);
        return temp;
    }

    @Override
    public Destination gettingDestinationInformation() {
        Destination des = new Destination();
        in = new Scanner(System.in);
        System.out.println("Please add destination id:");
        des.setDstId(in.nextInt());
        in.nextLine();
        System.out.println("Please add destination name:");
        try {
            des.setDstName(in.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Please add destination passengers:");
        try {
            des.setAvgPassengers(in.nextInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.nextLine();
        System.out.println("Please add destination distance:");
        des.setDistanceInKM(in.nextDouble());
        in.nextLine();
        System.out.println("Please add destination traveling time:");
        try {
            des.setHoursForTraveling(in.nextInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.nextLine();

        return des;
    }

    @Override
    public String gettingDestinationName() {
        in = new Scanner(System.in);
        System.out.println("Enter destination name:");
        return in.nextLine();
    }
}
