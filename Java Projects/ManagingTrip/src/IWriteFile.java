/**
 * Created by Damqnov on 14-1-21.
 */
public interface IWriteFile<T> {

    public void setFileName(String fileName);
    public void writeObject(T t);
    public void  createPrintStream();

}
