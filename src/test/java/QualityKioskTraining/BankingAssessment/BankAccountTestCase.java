package QualityKioskTraining.BankingAssessment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankAccountTestCase {
	String Res;
	String Res1;
    int Balance;
	int DepositAmount;
	int WithDrawAmount;
	int updatedBal;

	float CurrentBalance;

	BankAccountTestCase obj;
	double result=0;
	String res;
	final float InterestRate=0.5f;
	
	Scanner sc=new Scanner(System.in);
	
	@BeforeClass
	public void init() {
		obj=new BankAccountTestCase();
	}
	
	@BeforeMethod
	public void ReinitialiseRes() {
		
		res="null";
	}
	
	@BeforeGroups("RegressionTest")
	public void initGroups()
	{
		System.out.println("Before Groups");
		obj=new BankAccountTestCase();
	}
	
	
	@BeforeGroups("SmokeTest")
	public void initBeforeSmoke() {
		obj = new BankAccountTestCase();
	}
	
	//#1InitialBalance 
	@Test(priority=2,groups= {"RegressionTest"})
	public void InitialBalance() 
	{
		System.out.println("Enter amount ");
		Balance=sc.nextInt();
		res=obj.InitialBal(Balance);
		Assert.assertEquals(res, "Initial balance = "+Balance);
		System.out.println(res);
	
	}
	
	private String InitialBal(int balance2) {
		// TODO Auto-generated method stub
		return null;
	}

	//Opening Account test case
	@Test(priority=1,groups= {"RegressionTest"})
	public void openingofAcc(){
		
	
		System.out.println("Enter name");
		String AccountHolderName=sc.nextLine();
		
		System.out.println(" Enter Acc no");
		int AccountNo=sc.nextInt();
		res=obj.AccOpen(AccountNo, AccountHolderName);
		Assert.assertEquals(res, "Account no. = "+AccountNo+". Name = "+AccountHolderName+".","Account is opened");
		System.out.println(res);
		System.out.println("Account is opened");
		
	} 
	
	
	
	private String AccOpen(int accountNo, String accountHolderName) {
		// TODO Auto-generated method stub
		return null;
	}

		//Money Deposit test case
		@Test(priority=3,groups= {"RegressionTest"})
		public void DepositMoney() 
		{
			
			System.out.println("Enter amount to be deposited  "); //Take input-Deposit amount
			DepositAmount=sc.nextInt();
			
			Balance=Balance+DepositAmount; //Update AccBalance
			res=obj.Deposit(DepositAmount);
			Assert.assertEquals(res, "Amount deposited = "+DepositAmount, "Money is deposited in account.");
			System.out.println(res);
			System.out.println("Balance after Deposit "+Balance);
			
			}
		
		
		
		
		private String Deposit(int depositAmount2) {
			// TODO Auto-generated method stub
			return null;
		}

		//WithdrawMoney test case--
		@Test(priority=4,groups= {"RegressionTest"})
		public void withDraw() 
		{
			
			
			System.out.println("Enter amount to be withdrawn  ");
			WithDrawAmount=sc.nextInt(); //Take amount to be withdrawn
			
			if(WithDrawAmount<=Balance)
			{
				Balance=Balance-WithDrawAmount; //update balance after withdraw
			res=obj.Withdraw(WithDrawAmount);
			Assert.assertEquals(res, "Amount withdrawn= "+WithDrawAmount,"amount is withdrawn" );
			System.out.println(res);
			
			}
			else {
				System.out.println("Amount is greater than balance");
			}
			
		}
	
		private String Withdraw(int withDrawAmount2) {
			// TODO Auto-generated method stub
			return null;
		}

	//Saving account test case
	@Test(priority=5, groups= {"SmokeTest"})
	public void SavingAcc(){
	
		System.out.println("Enter Account No : "); //Take saving acc no
		int savingAccNo=sc.nextInt();
		
		System.out.println("Enter Saving Amount : "); //Take saving amount
		int savingBalance=sc.nextInt();  
		float savingAccBalance=savingBalance+(savingBalance*InterestRate); //Update saving amount
		
		res=obj.savingAcc("You have "+savingAccBalance+" in your saving account");
		
		System.out.println(savingAccBalance+"-- Current account balance with Interest for account number "+savingAccNo);
		
		
	}
	
	private String savingAcc(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	//Salary account test case
	@Test(priority=6, groups= {"SmokeTest"})
	public void salaryAccount() {
		
		System.out.println("If you want to open salary account, provide following details");
		
		System.out.println("Enter your Name ");
		String name=sc.next();
		System.out.println("Employye name: "+name);
		
		System.out.println("Enter your Starting Amount ");
		int startingAmount=sc.nextInt();
		System.out.println("Starting Balance: "+startingAmount);
		System.out.println("Thank You! Your account will be opened within 4-5 working days");
		
		System.out.println("Enter your contact no");
		int mobno=sc.nextInt();
		System.out.println("mobile no: "+mobno);
		System.out.println("Thank You! Your account will be opened within 4-5 working days");
		
		
	}
	
	@AfterMethod
	public void clearResult() {
		System.out.println("After Mehtod");
		result =0;
		
	}

	@AfterClass
	public void tearDown() {
		obj = null;
	}
	
	//to save report in specified folder
	
	@BeforeSuite
	@Parameters({"RequestID"})

	public void createResultFolder(String ResultDir) {
		System.out.println("I am in before Suite");
		try
		{
		Files.createDirectories(Paths.get("./"+ResultDir));
		}
		catch (IOException e)
		{
			System.out.println("Problem in creating a Result Directory");
		}
		
	}

	@Parameters({"RequestID"})
	@AfterSuite

	public void copyResultFile(String RequestID) throws Exception{
		System.out.println("I am in after Suite");
		try {
			Files.copy(Paths.get("C:\\Users\\q6730\\Desktop\\BankingAssessment\\test-output\\emailable-report.html"), Paths.get("./"+RequestID+"/Result.html"),StandardCopyOption.REPLACE_EXISTING);	}
		catch (IOException e) {
			// TODO Auto-generated catch block
				System.out.println("Problem in copying Result file");
		}
	}

}

