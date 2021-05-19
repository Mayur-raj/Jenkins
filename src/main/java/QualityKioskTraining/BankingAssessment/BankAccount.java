package QualityKioskTraining.BankingAssessment;

import java.util.Scanner;

public class BankAccount {
Scanner sc=new Scanner(System.in);
    
    //Opening Bank Account...
    
    public String AccOpen(int accountNo, String accountHolderName) {
		
		String Res1=("Account no. = "+accountNo+". Name = "+accountHolderName+".");
		return Res1;
	}

    //Checking Initial Balance...
    
    public String InitialBal(int Balance) {

		String  Res=("Initial balance = "+Balance);
		return Res;
	}
	
    //Deposit Money in Bank Account...
    
    public String Deposit(int DepositAmt) {

		String Res=("Amount deposited = "+DepositAmt); 
		return Res;
		
	}


    //withdraw from Bank Account...
	public String Withdraw(int withDrawAmount) {
	
		String Res=("Amount withdrawn= "+withDrawAmount);
		return Res;
	}


    //Saving Account..
    public String savingAcc(String string) {
		
		String Res=("You have "+string+" in your saving account");
		return Res;
	}

    

}
