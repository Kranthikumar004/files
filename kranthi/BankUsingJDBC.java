package jdbcPractice;

import java.util.Scanner;
import java.sql.*;

class InvalidAmountException extends Exception{

	private static final long serialVersionUID = 1L;
	
	InvalidAmountException() {
		super("Enter valid amount to withdraw");
	}	
}

class NoSufficientAmountException extends Exception {
	NoSufficientAmountException(String msg) {
		super(msg);
	} 
}

public class BankUsingJDBC {
	
	static Scanner scan;
	private int accountNo;
	private String password;
	private int balance;
	static Connection con;
	
	public void getBalance() throws SQLException {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select balance from customer where ACCOUNTNO="+Integer.toString(this.accountNo));
		rs.next();
		this.balance=rs.getInt(1);
	}
	public boolean verifyCredentials(int accNo, String pass) throws SQLException {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT PASSWORD FROM customer WHERE ACCOUNTNO="+Integer.toString(accNo)+";");
		rs.next();
		String originalPassword = rs.getString(1);
		if(originalPassword.equals(pass)) {
			return true;
		}
		else {
			return false;
		}
	}
	public void deposit() throws InvalidAmountException, SQLException{
		this.getBalance();
		System.out.print("Enter amount: ");
		int amt = Integer.parseInt(scan.nextLine());
		if(amt<500) {
			throw new InvalidAmountException();
		}
		else {
			PreparedStatement ps = con.prepareStatement("update customer set BALANCE="+Integer.toString((this.balance)+amt)+" where ACCOUNTNO="+Integer.toString(this.accountNo)+" ;");
			ps.executeUpdate();
			System.out.println("Amount of "+amt+" is deposited");
		}
	}
	public void withdraw() throws NoSufficientAmountException, SQLException{
		this.getBalance();
		System.out.print("Enter amount: ");
		int amt = Integer.parseInt(scan.nextLine());
		if(amt>this.balance) {
			throw new NoSufficientAmountException("No sufficient funds to withdraw");
		}
		else {
			PreparedStatement ps = con.prepareStatement("update customer set BALANCE="+Integer.toString((this.balance)-amt)+" where ACCOUNTNO="+Integer.toString(this.accountNo)+" ;");
			ps.executeUpdate();
			System.out.println("Amount of "+amt+" is withdrawn");
		}
	}
	public void checkBalance() throws SQLException {
		this.getBalance();
		System.out.println("Your remaining balance is "+this.balance);
	}
	public void transfer() throws SQLException, NoSufficientAmountException {
		this.getBalance();
		System.out.print("Enter other account number: ");
		int otherAcc = Integer.parseInt(scan.nextLine());
		int otherBalance = 0;
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from customer where ACCOUNTNO="+Integer.toString(otherAcc));
		if(rs.next()) {
			otherBalance = rs.getInt(3);
			System.out.print("Enter amount: ");
			int amt = Integer.parseInt(scan.nextLine());
			if(amt>this.balance) {
				throw new NoSufficientAmountException("No sufficient funds to withdraw");
			}
			else {
				PreparedStatement ps = con.prepareStatement("update customer set BALANCE="+Integer.toString((this.balance)-amt)+" where ACCOUNTNO="+Integer.toString(this.accountNo)+" ;");
				ps.executeUpdate();
				PreparedStatement ps2 = con.prepareStatement("update customer set BALANCE="+Integer.toString(otherBalance+amt)+" where ACCOUNTNO="+Integer.toString(otherAcc)+" ;");
				ps2.executeUpdate();
				System.out.println("Amount of "+amt+" is transferred to "+Integer.toString(otherAcc));
			}
			
		}
		else {
			System.out.println("Account number does not exist");
		}
		
	}
	public static void main(String[] args) throws SQLException, NoSufficientAmountException {
		BankUsingJDBC obj = new BankUsingJDBC();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","5577");
		
		scan = new Scanner(System.in);
		System.out.println("Welcome");
		System.out.print("Enter Account Number: ");
		obj.accountNo = Integer.parseInt(scan.nextLine());
		System.out.print("Enter Password: ");
		obj.password = scan.nextLine();
		boolean pass = false;
		int trails = 1;
		while(trails<3) {
			if(obj.verifyCredentials(obj.accountNo, obj.password)) {
				pass = true;
				break;
			}
			else {
				System.out.println("Enter correct password");
				System.out.print("Enter Password: ");
				obj.password = scan.nextLine();
				trails++;
			}
		}
		if(pass) {
			boolean go = true;
			while(go) {
				System.out.println("Select any option:\n");
				System.out.println("1) Deposit\n2) Withdraw\n3) Balance check\n4) Transfer Money\n5) Exit\n-");
				int choice = Integer.parseInt(scan.nextLine());
				switch(choice) {
				case 1: 
					try {
						obj.deposit();
					}
					catch(InvalidAmountException e) {
						e.printStackTrace();
					}
					break;	
				case 2:
					try {
						obj.withdraw();
					}
					catch(NoSufficientAmountException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					obj.checkBalance();
					break;
				case 4:
					obj.transfer();
					break;
				case 5:
					System.out.println("Exiting.....");
					System.exit(0);
					
				default:
					System.out.println("Give valid option between 1 and 5");
				}
			}
		}
		else {
			System.out.println("Account blocked");
			System.exit(0);
		}
	}

}
