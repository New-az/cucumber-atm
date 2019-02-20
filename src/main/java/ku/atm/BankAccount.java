package ku.atm;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount {
   private double balance;
   private double overdraft;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount() {
      balance = 0;
      overdraft = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance) {
      balance = initialBalance;
   }

   public BankAccount(double initialBalance,double initialOverdraft){
      balance = initialBalance;
      overdraft = initialOverdraft;
   }
 
   /** 
      Deposits money into the account.
      @param amount the amount of money to withdraw
   */
   public void deposit(double amount) {
      balance = balance + amount;
   }

   /** 
      Withdraws money from the account.
      @param amount the amount of money to deposit
   */
   public void withdraw(double amount) throws NotEnoughBalanceException {
       if (amount > balance) {
          double overall = balance + overdraft;
          if (amount > overall) {
             throw new NotEnoughBalanceException("cannot withdraw more than balance");
          }
          else{
             overdraft = overall- amount;
             balance = 0;
          }
       }
       else
         balance = balance - amount;
   }

   /** 
      Gets the account balance.
      @return the account balance
   */
   public double getBalance() {
      return balance; 
   }


   /**
    Gets the account overdraft.
    @return the account balance
    */
   public double getOverdraft() {
      return overdraft;
   }

}

