package moneyTracker;

import java.io.*;
import java.util.ArrayList;

public class FileHandler implements Serializable {

    String path;

    public FileHandler(String filename) {
        //found out the path - get current folder of the project
        this.path = System.getProperty("user.dir") + "/" + filename;
    }


    public FinTracker loadFromFile () throws IOException, ClassNotFoundException {

            // exception can be thrown, it will be handled from calling function
            // Reading the object from a file

            File f = new File(path);

            //if the file exist
            if(f.isFile()) {

                FileInputStream file = new FileInputStream(path);
                ObjectInputStream in = new ObjectInputStream(file);

                FinTracker finTracker = (FinTracker) in.readObject();

                in.close();
                file.close();

                return finTracker;
            }else { // if no, create the empthy file
                 return new FinTracker();
            }
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

