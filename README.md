# New-Bank-Acc-Creation-App

## Scenario

Small project where creatign a an application to handle new customer bank accounts request from a CSV file that holds the information needed
### The application doess the following

- Read a .csv file containing the names, Social Securoty Number (SSN) , account type and initial deposit


- User proper data Structure to hold this accounts


- Two types of accounts, *Checkings* and *Savings* both share the following properties:
    - *deposit()*
    - *withdrawl()*
    - *transfer()*
    - *showInfo()*
    - *11-Digit ID number generated in the following process: 1 o 2 depending of if the account is Savings or Checking, last two digits of the SSN, unique 5-digit number, 3-digit randomly generated*
    

- Savings accounts holders are given a Safety Deposit Box, identified by a 3-digit number and access with a 4 digit code


- Checking accounts holders are assigned a Debit Card with a 12-digit number and a 4-dgit PIN


- Both accounts will use an interace that determinates the base interest rate
    - Savings accs will use .25 points less that the base rate
    - Checking accs will use 15% 


- A *showInfo()* methods should reveal relevant account's information as well as information specific to the Checkings or Savings account

## Classes and Methods

### Account class

Abstract class that implements the *Base Rate* interface, as no objects will be created from here. 

This class will play the rle of the parent of Checking and Savings classes where from the actual objects will be created, all relevant attributes and methods for both child classes will be here.

#### *Attributes*

- private String name; - references new client's name
- private String sSN; - References new client's SSN
- private double balance; - References to Balance of client
- protected  String accountNumber; - Reference of client's Account number 
- protected double rate; - Reference to the calcutated rate depending if it's avings or Checking account
- private static int index = 10001; - Constant variable of 5-digits number part of the ID

#### *Account Constructor*

At the moment of the Account creation it will set the base porperties
- name - Passsed as arg
- sSN - Passed as arg
- Balance equals to initial deposit - passed as arg
- Account number equals to what *setAccoountNumber()* returns
- Index ++ for every account created

#### *Account Methods*

##### setRate()
Public abstract method that has to be implemented from implementing the Base Rate interface (see further below) this method will be override in Checking and Savings accout as per specifications above

##### setAccountNumber 
Private Method use to set the account number based on 11-Digit ID number generated in the following process: 1 o 2 depending of if the account is Savings or Checking, last two digits of the SSN, unique 5-digit number, 3-digit randomly generated. Algorithm as follows:
- Substring from from the SSN with the last two numbers
- Unique id equals to index ath the moment of the account creation
- Generate a 3-random number
- Returns returns the concatination of the Substring, uniqueID and the 3-random number generated

##### compoundInterest()
Method tha can be use to calculate compound interest of an account holder. Algorithm as follows
- Accured calculated interest equals balance times (rate/100)
- baance += accured interest
- Print the accured interest of the account holder
- Print balance

##### deposit()
Method that allows to make deposits into the account, it takes an *amount* as argument to be deposit, algorithm as follows:
- balance += amount
- Printing the amount being deposited
- Print balance

##### withdraw()
Method that allows making withdraws out of the account, it takes an *amount* as argument to be withdraw, algorithm as follows:
- if balance is less than the amount
    - print there is not enough resources for the operation
- else 
    - printing the amount witdrawing
    - balance -= amount
- Print balance

##### transfer()
Similar to withdraw(), with the addition of taking also a String *toWhere* as argument refering where the amount will be transfered.

##### printBalance()
Method used to print the balance.

##### showInfo()
Method used to print the relevant information, name, account number and balance of an account holder regardless if is Checking or Savings

### Checking class
Class from which a new Saving account will be created

#### *Attributes*
- Private DebitCard card - As per specifications Checking accounts will be assigned a Debit card

#### *Checking Constructor*
At the moment of the Account creation, if the account is of the type Checking, it will set the base properties plus the properties for checking account, takes name, SSN and initial deposit as parameters from Account (*super()*)
- Name, sSN, initial deposit from account
- As Checking account, acountnumber equas "2" + account number
- As Checking account, create a new Debit Card
- Set Cheking interest rate

#### *Checking Methods*

##### showInfo()
Method to print the account info plus relevant information to Checking account. Algorithm as follow;
- Account.showInfo (super)
- Print debit card's number using getters from DebitCard Class
- Print debit card's pin using getters from DebitCard Class

##### override setRate();
As per requirements, Checking accs will use 15% calculated as follow:
- rate equals get the base rate by 0.15

### DebitCard Class
Class from which a new debit card will be created when a Checking account is open

#### *Attributes*
- private long debitCardNumber; Reference to the debit car number
- private int debitCardPin; Reference to the debit card pin

#### *DebitCard Constructor*
At the moent of the Checking acc creation a new Debit card will be generated, this constructor will call the set the DC number and the DB pin using the setters in the class

#### *DebitCard methods*

##### getDebitCardNumber() and getDebitCardPin()
Methods use to access the values of the DC number and DC pin, they return their respective values

##### setDebitCardNumber()
This method generates a 12-digit random number to be assigedn to *debitCardNumber*

##### setDebitCardPin()
This method generates a 4-digit random number to be assigedn to *debitCardPin*

### Savings class
Class from which a new Saving account will be created

#### *Attributes*
- Private SateyDepositBox sdb - As per specifications Savings accounts will be assigned a safety deposit box 

#### *Savings Constructor*
At the moment of the Account creation, if the account is of the type Savings, it will set the base properties plus the properties for Savings account, takes name, SSN and initial deposit as parameters from Account (*super()*)
- Name, sSN, initial deposit from account
- As Savings account, acountnumber equas "1" + account number
- As Savings account, create a new Sefaty Deposit Box
- Set Savings interest rate

#### *Savings Method*

##### showInfo()
Method to print the account info plus relevant information to Savings account. Algorithm as follow;
- Account.showInfo (super)
- Print Safety Deposit Box ID using getters from SafetyDepositBox Class
- Print Safety Deposit Box key using getters from SafetyDepositBox Class

##### override setRate();
As per requirements, Savings accs will use .25 points less that the base rate calculated as follow
- rate equals get the base rate minus .25

### SafetyDepositBox Class
Class from which a new safety deposit box will be created when a Savings account is open

#### *Attributes*
- private int safeDepositBoxIC; Reference to the 3-digit number deposit box Id
- private int safeDepositBoxKey; Reference to the 4-digit number safe deposit box code

#### *SafetyDepositBox Constructor*
At the moent of the Savings acc creation a new Safety Deposit Box will be generated, this constructor will call the set the DC number and the DB pin using the setters in the class

#### *SafetyDepopsitBox methods*

##### getSafeDepositBoxID() and getSafeDepositoxKey()
Methods use to access the values of the SDB ID and SDB code, they return their respective values

##### setSafeDepositBoxID()
This method generates a 3-digit random number to be assigedn to *SafeDepositBoxID*

##### setSafeDepositBoxKey()
This method generates a 4-digit random number to be assigedn to *debitCardPin*

### IBaseRate Interface
This project assumes that this information will be taken from a external API i.e. the Federal Bank

#### *IBaseRate Method*
- Returns the base rate equals 2.5, (number randomly selected)

### CSV Class
Abstract class - as we don't want an instance of this class - which provides the method to read the CSV file passed from where the accounts will be created, does not contains any atributes

#### *CSV Methods*

##### read()
Static method which returns a LinkedList (preserves the order of addition) of strings created from reading the file passed as parameter using *try-with-resources*, *BufferedReader* and *FileReader* from Java with own printing exceptions. Algorithm as follow:
- Initialise a List of Strings called *data*
- Declare a String variable called *dataRow*
- Try
    - while dataRow is not null
        - split the dataRow
        - added to data
- Catch File not found exception
    - Print "File not found"
- Catch IOException
    - Print "File could not be readed"
- return data

## Main Class BankAccountApp
Starting point of our progam, it contains the main method. When the program starts will create a List of accounts where the accounts created will be stored

1. List to store the accounts (either Checking or Savings) Created by reading the CSV file
2. Read CSV file and then create new accounts base on that data using CSV read(). create the accounts.Alternative CSV.read("NewBankAccounts.csv") can be pass directly to the for-each
3. Looping through the list returned by read() using the index to access the information
    - If account type equals Savings create a new Savings acc
    - If account type equals Checking create a new Checking acc
    - Else there was an error
4. For-each printing all the accounts created to confirm it work
5. Getting a random account holder and confirm methods are working as expected


## Learning outcome
- Develop Object-Orieneted application architecture
- Use of Abstract classes an Methods
- Use of an Interface that assume it receives information form a API
- Depper use of constructors
- Proper use of access modifiers Private, Protected and Public (encapsulation) 
- Read data from a file and store the data in an appropiate Data Structure (ArrayList)
- Generation of Random numbers
