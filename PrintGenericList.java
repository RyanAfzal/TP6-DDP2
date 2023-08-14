import java.util.List;

public class PrintGenericList<T> {
    public List<T> lst;

    public PrintGenericList(List<T> lst) {
        this.lst = lst;
    }

    public void printToConsole(){
        for (T item : this.lst) {
            System.out.println(item);
        }
    }
}
