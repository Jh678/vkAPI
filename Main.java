import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id группы: ");
        String id = in.nextLine();
        Constructor.CreateDatabase(id);
    }
}
