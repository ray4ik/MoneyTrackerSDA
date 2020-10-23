# MoneyTracker

MoneyTracker is a Java application for working with the expense(s) and income(s). 
 Application allows a user to enter, edit and delete the expense(s) and income(s). 
 The expense(s) and income(s) contain the name, the price and month when expense / income was done. 
 All inserted items are saved and when application restarted again, items are available. 
 User interacts with an application via the command-line text based interface. 

# Setting up

1. Download the code from [GitHub](https://github.com/ray4ik/MoneyTrackerSDA)
2. Go to folder MoneyTrackerSDA/src/main/java and compile Program.java

```bash
javac Program.java
```
3. Now you can run the application: 
```bash
java Program
```
4. Now you can use the application. Please choose what you are going to do.
```bash
Welcome to Money Tracker
You have currently 0 SEK on your account. 
(1) Show items  - All /  Expense / Income
(2) Add Expense / Income
(3) Edit Item / Delete 
(4) Save and Quite
```

# Getting started
When you run MoneyTracker for the first time, you can see the next "Welcome screen" with the current balance which is 0 SEK and Main menu with 4 available options. 

```bash
Welcome to Money Tracker
You have currently 0 SEK on your account. 
(1) Show items  - All /  Expense / Income
(2) Add Expense / Income
(3) Edit Item / Delete 
(4) Save and quite
```

# How to Add item
Option 1 shows all the items. But since you start application for the first time, input "2" to the command line to add the first item. If you want to add expense input "1", else "2".

```bash
(1) Show items  - All /  Expense / Income)
(2) Add Expense / Income
(3) Edit Item / Delete 
(4) Save and quite
2
Enter 1 for inserting expense, 2 - for income 
1
Add name of item 
```
Then input the name, price and month. Month has special format. You have to input values from 1 to 12. 1 means January, 2 - February, 3 - March etc. 

```bash
Enter 1 for inserting expense, 2 - for income 
1
Add name of item 
cake   
Add price of the item 
25
Input month (1 = Jan, 12 = Dec)
10
```
After proper insertion of all the items program says and get you back to the main menu. 
Note. You don't need to care about "-" sign of expenses. Since expenses under "1" and incomes under "2" no need to worry about signs. Just add every time positive values. 

```bash
Item is saving....
Item is saved!
(1) Show items  - All /  Expense / Income)
(2) Add Expense / Income
(3) Edit Item / Delete 
(4) Save and quite
```
# How to Edit item
You can Edit items by choosing "3" option in the Main Menu. And than input "1 "
Item is edited based on item id. When item is created, it receives the id. All ids follow simple sequence. The first item has id = 1, the second one has id = 2 and so on. Follow the instruction from command line to edit item. 

```bash
(1) Show items  - All /  Expense / Income)
(2) Add Expense / Income
(3) Edit Item / Delete 
(4) Save and quite
3
Enter 1 - to Edit item, 2 - to Delete item 
1
Enter id of the item 
1
Editing item  car -100000.0 1
Enter new name 
Volvo
Enter new price
100000            
Enter new month
Input month (1 = Jan, 12 = Dec)
1
Updating item...
Updating item with id 1
Updating car -100000.0 1
```

# How to Delete item
You can Delete items by choosing "3" option in the Main Menu. And than input "2 "
Item is deleted based on item id. When item is created, it receives the id. All ids follow simple sequence. The first item has id = 1, the second one has id = 2 and so on. Follow the instruction from command line to delete item. 
```bash
(1) Show items  - All /  Expense / Income)
(2) Add Expense / Income
(3) Edit Item / Delete 
(4) Save and quite
3
Enter 1 - to Edit item, 2 - to Delete item 
2
Enter id of the item you want to delete 
2
Entry with name coffee, price -3.000000 and month 1 to be deleted 
Entry with id = 2 was deleted
```

# How to Save entries and Exit 
Press "4" from main menu
```bash
(1) Show items  - All /  Expense / Income)
(2) Add Expense / Income
(3) Edit Item / Delete 
(4) Save and quite
4
Saving...
Object has been written to file
Saved!
```
Next time when you run application you can see all previously added items. To check it input "1" from the main menu.

# How to See item
Input "1" from the main menu. If you want to see all the items, input "1", if only expenses - input "2", if only incomes - input "3". 
```bash
1
Enter 1 for displaying of All items, 2 - for All expense, 3 - for All income.
1
Volvo -100000.0 1
cake -25.0 10
salary 50000.0 11
```
Note. If you choose 1,  to understand what is income and what is expense, expense is marked with sign "-". But when you add the expense, you dont need to enter "-", just use positive values. 

# Notes
Application handles cases when user input incorrect values, for example, if user input wrong statement (not number) for the price

```bash
Enter 1 for inserting expense, 2 - for income 
1
Add name of item 
coffee
Add price of the item 
iiii
Incorrect price, please try again... 
```

It also checks that number related to the month is input correctly. For example, 
```bash
Input month (1 = Jan, 12 = Dec)
iii
Incorrect month, please insert number from 1 to 12... 
99
Incorrect month, please insert number from 1 to 12... 
1
Item is saving...
```


# System requirements
Java SE Development Kit (JDK)

