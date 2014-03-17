import java.util.ArrayList;

/**
 * Created by Damqnov on 14-1-21.
 */
public interface IUtilities {

    public void showAllDestinations();
    public void showAllAirplanes();
    public void addDestination(Destination d);
    public void addCompanyPlane(CompanyPlane p);
    public void findCompatiblePlain(String destinationName);

}
