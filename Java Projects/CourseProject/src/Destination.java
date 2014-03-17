import java.io.IOException;

/**
 * Created by Damqnov on 14-1-21.
 */
public class Destination {
    private int dstId;
    private String dstName;
    private double distanceInKM;
    private int avgPassengers;
    private int hoursForTraveling;

    Destination(int id,String name,double distance,int passengers,int hoursForTraveling){
        this.dstId=id;
        this.dstName=name;
        this.distanceInKM=distance;
        this.avgPassengers=passengers;
        this.hoursForTraveling=hoursForTraveling;

    }

    Destination(){
    }

    public int getHoursForTraveling() {
        return hoursForTraveling;
    }

    public void setHoursForTraveling(int hoursForTraveling) throws IOException {
        if(hoursForTraveling>0 && hoursForTraveling<20){
            this.hoursForTraveling = hoursForTraveling;
        }
        else{
            throw new IOException();
        }
    }

    public int getDstId() {
        return dstId;
    }

    public void setDstId(int dstId) {
        this.dstId = dstId;
    }

    public String getDstName() {
        return dstName;
    }

    public void setDstName(String dstName) throws IOException {
        if(dstName.length()>2 && dstName.length()<20){
            this.dstName = dstName;
        }
        else{
            throw new IOException();
        }
    }

    public double getDistanceInKM() {
        return distanceInKM;
    }

    public void setDistanceInKM(double distanceInKM) {
        if(distanceInKM<5000 && distanceInKM>0){
            this.distanceInKM = distanceInKM;
        }
        else{
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getAvgPassengers() {
        return avgPassengers;
    }

    public void setAvgPassengers(int avgPassengers) throws IOException {
        if(avgPassengers>0 && avgPassengers<300){
            this.avgPassengers = avgPassengers;
        }
        else{
            throw new IOException();
        }

    }


    @Override
    public String toString() {
        return "Destination{" +
                "dstId=" + dstId +
                ", dstName='" + dstName + '\'' +
                ", distanceInKM=" + distanceInKM +
                ", avgPassengers=" + avgPassengers +
                ", hoursForTraveling=" + hoursForTraveling +
                '}';
    }
}
