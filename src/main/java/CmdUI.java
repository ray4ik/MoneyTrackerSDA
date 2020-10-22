import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class CmdUI {

    //
    private FinTracker finTracker;
    private FileHandler fileHandler;

    public CmdUI (FinTracker ft, FileHandler fh) {
        finTracker = ft;
        fileHandler = fh;
    }

    public void welcome(){
        System.out.println("Welcome to Money Tracker");
        int balance = 0;
        balance = finTracker.getTotalBalance();

        System.out.format("You have currently %d SEK on your account. \n", balance);
    }

    // cmd that simulates UI
    public void mainMenu() throws IOException {

        try {
            while (true) {
                //main menu
                System.out.println("(1) Show items  - All /  Expense / Income)");
                System.out.println("(2) Add Expense / Income");
                System.out.println("(3) Edit Item / Delete ");
                System.out.println("(4) Save and quite");

                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));
                String choice = reader.readLine();

                // based on user choice, perform the action
                switch (choice) {
                    case "1" -> showItems();
                    case "2" -> addExpenseIncome();
                    case "3" -> EditDeleteItem();
                    case "4" -> {
                        System.out.println("Saving");
                        save();
                        return;
                    }
                    default -> System.out.println("Error, try to input again");
                }
            }
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void showItems() {

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, FinRecord> collectionOfRecords;

        // infinite reading of the buffer until user inserts the correct information.
        while (true) {
            try {
                System.out.println("Enter 1 for displaying of All items, 2 - for All expense, 3 - for All income.");
                int choice = Integer.parseInt(reader.readLine());
                //get all entries
                if (choice == 1) {
                    collectionOfRecords = finTracker.getAll();
                    break;
                    //get only expenses
                } else if (choice == 2) {
                    collectionOfRecords = finTracker.getExpenses();
                    break;
                    //get only income
                } else if (choice == 3) {
                    collectionOfRecords = finTracker.getIncome();
                    break;
                }
                else{
                       //it is possible to choose only 1, 2, 3. If user enter any other number, user will be asked to insert number again
                       System.out.println("Incorrect choice, please try again... ");
                    }
                } catch(Exception ex){
                    //in case if user inserts not integer
                    System.out.println("Incorrect choice, please try again... ");
                }
            }

        //show item based on users choice
        for (FinRecord value : collectionOfRecords.values()) {
            System.out.println(value.toString());
        }
    }

    void EditDeleteItem() {

            final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // handling if user wants to edit or delete expense or income
            while(true) {
                try {
                    System.out.println("Enter 1 - to Edit item, 2 - to Delete item ");
                    int choice = Integer.parseInt(reader.readLine());
                    if (choice == 1) {
                        EditItem();
                        break;
                    } else if (choice == 2) {
                        DeleteItem();
                        break;
                    } else {
                        System.out.println("Incorrect choice, please try again..");
                    }
                } catch (Exception ex) {
                    System.out.println("Incorrect choice, please try again");
                    //System.out.println(ex.getMessage());
                }
            }
    }

    private void EditItem() throws IOException {

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id of the item ");

        //read it from cmd
        int id = readIntFromCmd(reader, "Incorrect id, please try again... ");

        if (finTracker.getEntry(id) != null) {

            boolean isExpence = true;
            if (finTracker.getEntry(id).getPrice() > 0) {
                isExpence = false;
            }
            System.out.println("Editing item  " + finTracker.getEntry(id).toString());
            System.out.println("Enter new name ");
            String newName = readStringFromCmd(reader, "Incorrect name, please try again..");

            System.out.println("Enter new price");
            Double newPrice = readDoubleFromCmd(reader, "Incorrect price, please try again...");
            if (isExpence) {
                newPrice *= -1;
            }

            System.out.println("Enter new month");

            int newMonth = readMonthFromCmd(reader);

            System.out.println("Updating item...");
            finTracker.updateEntry(id, newName, newPrice, newMonth);
            System.out.format("Entry with id = %d was updated \n", id);
        }
        else {
            System.out.println("Entry with current id doesn't exist. ");
        }

    }

    private void DeleteItem() {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id of the item you want to delete ");

        int id = readIntFromCmd(reader, "Incorrect id, please try again... ");

        FinRecord toBeDeleted = finTracker.getEntry(id);

        if (toBeDeleted!= null) {
            System.out.format("Entry with name %s, price %f and month %d to be deleted \n", toBeDeleted.getName(),
                    toBeDeleted.getPrice(), toBeDeleted.getMonth());
            finTracker.removeEntry(id);
            System.out.format("Entry with id = %d was deleted \n", id);
        }
        else {
            System.out.println("Nothing to delete ");
        }
    }

    void addExpenseIncome() throws IOException {

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // handling if it is expense or income
        boolean isExpense = true;
        while(true) {
            try {
                System.out.println("Enter 1 for inserting expense, 2 - for income ");
                int choice = Integer.parseInt(reader.readLine());
                if (choice == 1) {
                    isExpense = true;
                    break;
                } else if (choice == 2) {
                    isExpense = false;
                    break;
                } else {
                    System.out.println("Incorrect choice, please try again... ");
                }
            } catch (Exception ex) {
                System.out.println("Incorrect choice, please try again... ");
            }
        }

        // read the name of entry
        System.out.println("Add name of item ");

        //TODO refactor, use readStringFromCmd function
        String name = reader.readLine();
        while (name.isEmpty())
        {
            System.out.println("incorrect name, please try again... ");
            name = reader.readLine();
        }

        //TODO refactor, use readDoubleFromCmd function
        double price;
        System.out.println("Add price of the item ");
        while(true) {
            try {
                price = Double.parseDouble(reader.readLine());
                break;
            } catch (Exception ex) {
                System.out.println("Incorrect price, please try again... ");
            }
        }

        int month = readMonthFromCmd(reader);

        System.out.println("Item is saving....");
        if (isExpense)
        {
            price *= -1;
        }
        finTracker.addEntry(name, price, month);
        System.out.println("Item is saved!");


    }

    void save() throws IOException {
        fileHandler.writeToFile(finTracker);
        System.out.println("Saved!");
    }

     int readIntFromCmd(BufferedReader readBuffer, String message) {
        int val;
        while(true) {
             try {
                 val = Integer.parseInt(readBuffer.readLine());
                 break;
             } catch (Exception ex) {
                 System.out.println(message);
                 //System.out.println(ex.getMessage());
             }
         }
        return val; 
     }

    double readDoubleFromCmd(BufferedReader readBuffer, String message) {
        double val;
        while(true) {
             try {
                 val = Double.parseDouble(readBuffer.readLine());
                 break;
             } catch (Exception ex) {
                 System.out.println(message);
             }
         }
        return val;
    }

    String readStringFromCmd(BufferedReader readBuffer, String message) {
         String name = null;
         try
         {
              name = readBuffer.readLine();
              while (name.isEmpty())
              {
                  System.out.println(message);
                  name = readBuffer.readLine();
              }
         }
         catch (Exception ex)
         {
             System.out.println(ex.toString());
         }
         return name;
    }

    int readMonthFromCmd(BufferedReader readBuffer) {
        int month;
        System.out.println("Input month (1 = Jan, 12 = Dec)");
        while(true) {
            try {
                month = Integer.parseInt(readBuffer.readLine());
                if ( month >= 1  && month <= 12) {
                    break;
                }
                else {
                    System.out.println("Incorrect month, please insert number from 1 to 12... ");
                }
            } catch (Exception ex) {
                System.out.println("Incorrect month, please insert number from 1 to 12... ");
            }
        }
        return month;
    }
}
