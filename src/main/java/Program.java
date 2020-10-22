import java.io.File;
import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {
        try {

            FileHandler fileHandler = new FileHandler("data");
            FinTracker finTracker = fileHandler.loadFromFile();

            CmdUI ui = new CmdUI(finTracker, fileHandler);
            ui.welcome();
            ui.mainMenu();
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
