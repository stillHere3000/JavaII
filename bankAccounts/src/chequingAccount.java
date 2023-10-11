public class chequingAccount extends Account {

    private double overDraftLimit = 1000.00;
    
    public static void main(String[] args) throws Exception {
        Account a= new Account(1122,20000.00);
        System.out.println(a.toString());

        chequingAccount chAccount= new chequingAccount(1122,20000.00);
        System.out.println( chAccount.toString() );

        savingsAccount svAccount= new savingsAccount(1122,20000.00);
        System.out.println( svAccount.toString());
    }

    public chequingAccount( int id, double balance) {
        super(id, balance);

    }

    public void withdraw(double w) {
        if (w > (this.getaccBalance()+this.overDraftLimit)) {
            System.out.println("Insufficient funds");
        } else {
            this.setAccBalance(this.getaccBalance() - w);
        }
    }

    public void deposit(double d) {
        this.setAccBalance(this.getaccBalance() + d);
    }

    public String toString() {
        return "Chequing Account: " + this.getAccId() + " Balance: " + this.getaccBalance()+
                " and the monthly interest is "+super.getMonthlyInterest()+ 
                " the account was created on "+super.getCreationDate();
    }
}
