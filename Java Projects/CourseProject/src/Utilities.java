import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Damqnov on 14-1-21.
 */
public class Utilities implements IUtilities{
    private static final String planeFileName="Planes";
    private static final String destinationFileName="Destination";


    @Override
    public void showAllDestinations() {
        ReadObjectDestination rod = new ReadObjectDestination();
        rod.setFileName(destinationFileName);
        rod.createBuffReader();
        ArrayList<Destination> list = new ArrayList<Destination>();
        list=rod.readAll();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }

    @Override
    public void showAllAirplanes() {
        ReadObjectCPlane roc = new ReadObjectCPlane();
        roc.setFileName(planeFileName);
        roc.createBuffReader();
        ArrayList<CompanyPlane> list = new ArrayList<CompanyPlane>();
        list=roc.readAll();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }



    }

    @Override
    public void addDestination(Destination d) {
         WriteObjectDestination wod = new WriteObjectDestination();
         wod.setFileName(destinationFileName);
         wod.createPrintStream();
         wod.writeObject(d);
    }

    @Override
    public void addCompanyPlane(CompanyPlane p) {
        WriteObjectCPlane woc = new WriteObjectCPlane();
        woc.setFileName(planeFileName);
        woc.createPrintStream();
        woc.writeObject(p);
    }

    @Override
    public void findCompatiblePlain(String destinationName) {
        ReadObjectCPlane roc = new ReadObjectCPlane();
        roc.setFileName(planeFileName);
        roc.createBuffReader();
        ArrayList<CompanyPlane> list = roc.readAll();
        ReadObjectDestination rod = new ReadObjectDestination();
        rod.setFileName(destinationFileName);
        rod.createBuffReader();
        Destination des=rod.getDestinationByName(destinationName);

        if(des==null){
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Compatible planes:");
        for(int i=0;i<list.size();i++){
            if( (int)des.getDistanceInKM() < list.get(i).getExpenses().getTankSizeInLiters()/list.get(i).getExpenses().getLittersPerKM() &&
                    des.getAvgPassengers()<list.get(i).getSeatsNumber()){
                System.out.println(list.get(i).toString());
            }
            else{
                System.out.println("Plane :"+ i + "is not compatible!");
            }
        }

    }
}
