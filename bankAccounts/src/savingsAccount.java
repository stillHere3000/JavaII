public class savingsAccount extends Account{


    public static void main(String[] args) throws Exception {
        Account a= new Account(1122,20000.00);
        System.out.println(a.toString());

        chequingAccount chAccount= new chequingAccount(1122,20000.00);
        System.out.println( chAccount.toString() );

        savingsAccount svAccount= new savingsAccount(1122,20000.00);
        System.out.println( svAccount.toString());
    }

    public savingsAccount( int id, double balance) {
        super(id, balance);
    }

    public void withdraw(double w) {
        if (w > this.getaccBalance()) {
            System.out.println("Insufficient funds");
        } else {
            this.setAccBalance(this.getaccBalance() - w);
        }
    }

    public void deposit(double d) {
        this.setAccBalance(this.getaccBalance() + d);
    }

    public String toString() {
        return "Savings Account: " + this.getAccId() + " Balance: " + super.getaccBalance()+
               " and the monthly interest is "+super.getMonthlyInterest()+ 
                " the account was created on "+super.getCreationDate();
    }
}