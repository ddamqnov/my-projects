import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Damqnov on 14-1-21.
 */
public class WriteObjectDestination implements  IWriteFile<Destination>{
 private static String fileName;
 private static PrintStream ps;

    @Override
    public void setFileName(String fileName) {
        this.fileName=fileName;
    }

    @Override
    public void writeObject(Destination o) {
        String temp;
        temp=o.getDstId()+":"+o.getDstName()+":"+o.getDistanceInKM()+":"+o.getAvgPassengers()+":"+o.getHoursForTraveling();
        ps.println(temp);
    }

    @Override
    public void createPrintStream() {

        try {
            ps= new PrintStream(new FileOutputStream(fileName+".txt",true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
