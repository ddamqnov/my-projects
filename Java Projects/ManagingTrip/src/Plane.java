import java.io.IOException;
    
/**
 * Created by Damqnov on 14-1-21.
 */
public class Plane {
    //   Класът на самолета включва производителя, модела, броя места и минималната дължина на пистата за кацане/излитане.
    private String producer;
    private String model;
    private int seatsNumber;
    private double landingSpace;

    Plane(String p,String m,int s,double l){
        this.producer=p;
        this.model=m;
        this.seatsNumber=s;
        this.landingSpace=l;
    }

    Plane(){
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) throws IOException {
        if(producer.length()<12){
        this.producer = producer;
        }
        else{
            throw new IOException();
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) throws IOException {
        if(model.length()<12){
            this.model = model;
        }
        else{
            throw new IOException();
        }
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) throws IOException {
        if(seatsNumber>0 && seatsNumber<300){
            this.seatsNumber = seatsNumber;
        }
        else{
            throw new IOException();
        }
    }

    public double getLandingSpace() {
        return landingSpace;
    }

    public void setLandingSpace(double landingSpace) throws IOException {
        if(landingSpace>0 && landingSpace<5000){
            this.landingSpace = landingSpace;
        }
        else{
            throw new IOException();
        }

    }

    @Override
    public String toString() {
        return "Plane{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", seatsNumber=" + seatsNumber +
                ", landingSpace=" + landingSpace +
                '}';
    }
}
