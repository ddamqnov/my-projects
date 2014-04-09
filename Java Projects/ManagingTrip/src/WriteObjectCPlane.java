import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Damqnov on 14-1-21.
 */
public class WriteObjectCPlane implements IWriteFile<CompanyPlane>{
    private static String fileName;
    private PrintStream ps;

    @Override
    public void setFileName(String fileName) {
        this.fileName=fileName;
    }


    public void writeObject(CompanyPlane o) {
        String plane=o.getPlaneId()+":"+o.getProducer()+":"+o.getModel()+":"+o.getSeatsNumber()+":"+o.getLandingSpace();
        String expenses=o.getExpenses().getPersonalExpenses()+":"+o.getExpenses().getTankSizeInLiters()+
                ":"+o.getExpenses().getAverageSpeed()+":"+o.getExpenses().getLittersPerKM();
        ps.println(plane+":"+expenses);

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
