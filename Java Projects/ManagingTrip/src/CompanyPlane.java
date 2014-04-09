/**
 * Created by Damqnov on 14-1-21.
 */
public class CompanyPlane extends Plane {

    private int planeId;
    private PlaneExpenses expenses;

    CompanyPlane(int id,PlaneExpenses expenses,String p,String m,int s,double l){
        super(p,m,s,l);
        this.planeId=id;
        this.expenses=expenses;
    }

    CompanyPlane(){
    }

    public PlaneExpenses getExpenses() {
        return expenses;
    }

    public void setExpenses(PlaneExpenses expenses) {
        this.expenses = expenses;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId)
    {
        this.planeId = planeId;
    }

    @Override
    public String toString() {
        return "CompanyPlane{" +
                "planeId=" + planeId +
                ", expenses=" + expenses.toString() +
                "} " + super.toString();
    }
}
