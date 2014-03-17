import java.io.*;
import java.util.ArrayList;

/**
 * Created by Damqnov on 14-1-21.
 */
public class ReadObjectCPlane implements IReadFile{
    private static  String fileName;
    private static BufferedReader in;

    @Override
    public void setFileName(String fileName) {
        this.fileName=fileName;
    }

    @Override
    public void createBuffReader() {
        File workFile= new File(fileName+".txt");
        try {
            in = new BufferedReader(new FileReader(workFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<CompanyPlane> readAll() {
        String temp=null;
        ArrayList<CompanyPlane> list = new ArrayList<CompanyPlane>();
        try {
            while((temp=in.readLine())!=null){
                list.add(readObject(temp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public CompanyPlane fillObject(String information) {
        String[] array;
        CompanyPlane temp=null;
        array=information.split(":");
        int id=Integer.parseInt(array[0]);
        String producer=array[1];
        String model=array[2];
        int seats = Integer.parseInt(array[3]);
        double landingSpace=Double.parseDouble(array[4]);
        double personalExpenses=Double.parseDouble(array[5]);
        int tankSize = Integer.parseInt(array[6]);
        int avgSpeed = Integer.parseInt(array[7]);
        int fuelPerKM = Integer.parseInt(array[8]);
        PlaneExpenses pe = new PlaneExpenses(personalExpenses,tankSize,avgSpeed,fuelPerKM);
         temp = new CompanyPlane(id,pe,producer,model,seats,landingSpace);
        return temp;
    }

    @Override
    public CompanyPlane readObject(String temp) {
        String information = null;
                information=temp;
        return fillObject(information);
    }
}
