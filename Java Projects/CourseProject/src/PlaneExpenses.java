/**
 * Created by Damqnov on 14-1-21.
 */
public class PlaneExpenses {
    //Такива са разходите за необходимия персонал, разход на гориво за 1 километър на едно място.
    // За оценка на максималната далечина на полета са необходими данни за обем на резервоара в литри.
    // За оценка продължителността на полетите и за натовареността на пилотите трябва да се съхраняват данни за средната скорост на самолетите от класа.
    private double personalExpenses;
    private int tankSizeInLiters;
    private int averageSpeed;
    private int littersPerKM;

    PlaneExpenses(){
    }

    PlaneExpenses(double personalExpenses,int tankSizeInLiters, int averageSpeed,int littersPerKM){
        this.personalExpenses=personalExpenses;
        this.tankSizeInLiters=tankSizeInLiters;
        this.averageSpeed=averageSpeed;
        this.littersPerKM=littersPerKM;
    }


    public double getPersonalExpenses() {
        return personalExpenses;
    }

    public void setPersonalExpenses(double personalExpenses) {
        this.personalExpenses = personalExpenses;
    }

    public int getTankSizeInLiters() {
        return tankSizeInLiters;
    }

    public void setTankSizeInLiters(int tankSizeInLiters) {
        this.tankSizeInLiters = tankSizeInLiters;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public int getLittersPerKM() {
        return littersPerKM;
    }

    public void setLittersPerKM(int littersPerKM) {
        this.littersPerKM = littersPerKM;
    }

    @Override
    public String toString() {
        return "PlaneExpenses{" +
                "personalExpenses=" + personalExpenses +
                ", tankSizeInLiters=" + tankSizeInLiters +
                ", averageSpeed=" + averageSpeed +
                ", littersPerKM=" + littersPerKM +
                '}';
    }
}
