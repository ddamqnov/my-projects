import java.io.*;
import java.util.ArrayList;

/**
 * Created by Damqnov on 14-1-21.
 */
public class ReadObjectDestination implements IReadFile{
    private static String fileName;
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
    public ArrayList readAll() {
        String temp=null;
        ArrayList<Destination> list = new ArrayList<Destination>();
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
    public Destination readObject(String temp) {
        String information = null;
        information=temp;
        return fillObject(information);
    }

    @Override
    public Destination fillObject(String information) {
        String[] array;
        array=information.split(":");
        int id = Integer.parseInt(array[0]);
        String name = array[1];
        double distance = Double.parseDouble(array[2]);
        int passengers = Integer.parseInt(array[3]);
        int hoursForTraveling= Integer.parseInt(array[4]);
        Destination destination = new Destination(id,name,distance,passengers,hoursForTraveling);
        return destination;
    }


    public Destination getDestinationByName(String dstName){
        Destination temp= null;
        String tempString=null;

        try {
            while((tempString=in.readLine())!=null){
                temp=readObject(tempString);
                if(temp.getDstName().equals(dstName)){
                    return temp;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return temp;
    }
}
