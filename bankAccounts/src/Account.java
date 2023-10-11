//import java.rmi.dgc.DGC;
import java.util.Date;
//import java.util.Scanner;


/*
 * 
 * 
 */
public class Account {
    private int id;
    private double accountBalance;
    private double annualInterestRate;

    private Date dateCreated;

    /*
     * Write a test program that creates an Account object with an account ID of 1122, a
balance of $20,000, and an annual interest rate of 4.5%. Use the withdraw method to
withdraw $2,500, use the deposit method to deposit $3,000, and print the balance,
the monthly interest, and the date when this account was created. 
     */
    public static void main(String[] args) throws Exception {
        /*Account a= new Account(1122,20000.00);
        a.withdraw(2500.00);
        a.deposit(3000); 
        
        System.out.println("The Balance is "+a.getaccBalance()+
                            " and the monthly interest is "+a.getMonthlyInterest()+ 
                            " the account was created on "+ a.getCreationDate());*/
        Account a= new Account(1122,20000.00);
        System.out.println(a.toString());

        chequingAccount chAccount= new chequingAccount(1122,20000.00);
        System.out.println( chAccount.toString() );

        savingsAccount svAccount= new savingsAccount(1122,20000.00);
        System.out.println( svAccount.toString());
    }

    public Account(){

    }

    public Account( int tempid, Double Bal){
        this.id= tempid; this.accountBalance= Bal;
        this.annualInterestRate= 0.0045; this.dateCreated= new java.util.Date();
    }

    public int getAccId(){ return this.id;}

    public void setAccId( int x){ this.id= x;}

    public double getaccBalance(){ return this.accountBalance; }

    public void setAccBalance( double x){ }

    public double getAnnualInterest(){ return this.annualInterestRate; }

    public double getMonthlyInterestRate(){ return this.annualInterestRate/12;}

    public double getMonthlyInterest(){ return this.accountBalance*this.getMonthlyInterestRate();}    

    public void setAnnualInterest( double x){ this.accountBalance= x; }

    public Date getCreationDate(){ return this.dateCreated;}

    public void withdraw(double w){ this.accountBalance= this.accountBalance- w;}

    public void deposit(double d){ this.accountBalance= this.accountBalance + d;}
    
    public String toString(){
       return ("The Balance is "+this.getaccBalance()+
                            " and the monthly interest is "+this.getMonthlyInterest()+ 
                            " the account was created on "+ this.getCreationDate());
    }


}


