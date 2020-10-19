import java.io.*;
import java.util.ArrayList;

public class FileHandler implements Serializable {

    String path;

    FileHandler(String filename) {
        //found out the path - get current folder of the project
        this.path = System.getProperty("user.dir") + "/" + filename;
    }

    public FinTracker loadFromFile () throws IOException, ClassNotFoundException {

            // exception can be thrown, it will be handled from calling function
            // Reading the object from a file
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);

            FinTracker finTracker = (FinTracker)in.readObject();

            in.close();
            file.close();

            return finTracker;
    }

    public void writeToFile(FinTracker tracker) throws IOException {

        // exception can be thrown, it will be handled from calling function
        //Saving  object in a file, rewrite file
        FileOutputStream file = new FileOutputStream(path, false);
        ObjectOutputStream out = new ObjectOutputStream(file);

        // serialization of object
        out.writeObject(tracker);

        out.close();
        file.close();

        System.out.println("Object has been written to file");
    }
}






    //String path = new File(".").getCanonicalPath();

   /* public void LoadFromFile ()
    {

    }

    public void WriteToFile(ArrayList<FinTracker> list)
    {
        try {
            FileOutputStream file = new FileOutputStream(path + "");
            ObjectOutputStream output = new ObjectOutputStream(file);
            // writes objects to output stream
            output.writeObject(list);

            output.close();
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("File doesn't found " +  e);
        }
    } */

