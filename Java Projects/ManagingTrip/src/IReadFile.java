import java.util.ArrayList;

/**
 * Created by Damqnov on 14-1-21.
 */
public interface IReadFile<T> {

    public void setFileName(String fileName);
    public void createBuffReader();
    public <T> T readObject(String param);
    public <T> T fillObject(String information);
    public ArrayList<T> readAll();
}
