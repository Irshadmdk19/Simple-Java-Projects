import java.util.Scanner;

// import javax.lang.model.util.ElementScanner14;

public class BankingApplication {
    
    public static void main(String[] args) {
        BankAccount obj1= new BankAccount("Irshad",036);
        obj1.ShowMenu();


    }
}
class BankAccount
{
    long balance;
    int previousTransaction;
    String customerName;
    int customerId;

    BankAccount(String customerName, int customerId)
    {
        this.customerName=customerName;
        this.customerId=customerId;
    }
    void deposit(int amount)
    {
        if(amount!=0)
        {
        balance= balance+amount;
        previousTransaction=amount;
        }
    }
    void withdrawl(int amount)
     {
        balance=balance-amount;
        previousTransaction= -amount;
    }
    void getPreviousTransaction()
     {
        if(previousTransaction>0)
        {
            System.out.println("Deposited Amount: "+previousTransaction);
        }
        else if(previousTransaction<0)
        {
            System.out.println("Withdrawn amount: "+Math.abs(previousTransaction));
        }
        else 
        {
            System.out.println("No Transaction");

        }
    }

        int  ShowMenu()
        {
          int choice;
          Scanner in = new Scanner(System.in);
          System.out.println("WELCOME TO CANARA BANK");
          System.out.println("-----------------------");
          System.out.println("Customer Name: "+customerName);
          System.out.println("Customer Id: "+customerId);
          System.out.println("-----------------------");
          System.out.println("1.Check Balance");
          System.out.println("2.Deposit");
          System.out.println("3.Withdraw");
          System.out.println("4.Previous Transaction");
          System.out.println("5.Exit");
          System.out.println("---------------------------");
          do{
              System.out.println("\n");
              System.out.println("______________________");
              System.out.println("Enter the option");
              System.out.println("----------------------");
            //   System.out.println("\n");
              choice =in.nextInt();
              switch(choice)
              {
                case 1: System.out.println("======================");
                System.out.println("BALANCE: "+balance);
                System.out.println("======================");
                break;

                case 2: System.out.println("======================");
                System.out.println("Enter the amount to deposit: ");
                System.out.println("======================");
                int amt= in.nextInt();
                deposit(amt);
                break;

                case 3: System.out.println("======================");
                System.out.println("Enter the amount to withdraw: ");
                System.out.println("======================");
                int wid=in.nextInt();
                withdrawl(wid);
                break;

                case 4: System.out.println("======================");
                getPreviousTransaction();
                System.out.println("======================");
                break;

                case 5: System.out.println("*******************");
                System.out.println("Logging out!!!");
                break;

                default:System.out.println("Invalid option!");
                break;

              }

          }while(choice!=5);
        

          System.out.println("Thank you for Banking, have a nice day!");
          in.close();
          return 0;
        }

}




