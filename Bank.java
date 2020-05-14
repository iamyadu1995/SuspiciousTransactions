
import java.io.*;
import java.net.URL;
import java.util.*;

public class Bank {
	
	static boolean customerTokenizer(String FromAccount, String ToAccount) {
		
		try {
			File customerFile = new File("D:\\asssign\\Customers.txt");
			FileReader fr2 = new FileReader(customerFile);
			BufferedReader br2 = new BufferedReader(fr2);
			StringBuffer sb2 = new StringBuffer();
			String customer,addToCheck="",phonenoToCheck="";
			int i=0,k=0;
		while((customer = br2.readLine())!= null) {
			sb2.append(customer);
			sb2.append("\n");
			
			StringTokenizer customerfields = new StringTokenizer(customer,"|");
			int j=0;
			while(customerfields.hasMoreTokens()) {
				String account;
				if(i>0) {
					if(j==0) {
						account = customerfields.nextToken();
						customerfields.nextToken();
						if(account.equalsIgnoreCase(FromAccount) || account.equalsIgnoreCase(ToAccount)) {
							if(k==0) {
								addToCheck=customerfields.nextToken();
								phonenoToCheck=customerfields.nextToken();
								k++;
							}
							else {
								String newAdd=customerfields.nextToken();
								String newPh=customerfields.nextToken();
								if(addToCheck.equalsIgnoreCase(newAdd) && phonenoToCheck.equalsIgnoreCase(newPh))
								{
									return true;
								}
							}
							
						}
						else {j++;}
					}
					else {
						customerfields.nextToken();
						j++;
					}
					
				}
				else {
					customerfields.nextToken();
				}
				
			}
			
			i++;
		}
		br2.close();
		} catch(IOException e) {
			System.out.println("Customer File Not Found");
			e.printStackTrace();
		}
		return false;
	}
	
	static void suspiciousTransactions() {
		try {
			File transactionFile = new File("D:\\asssign\\Transactions.txt");
			FileReader fr1 = new FileReader(transactionFile);
			BufferedReader br1 = new BufferedReader(fr1);
			StringBuffer sb1 = new StringBuffer();
			String transaction;
			int i=0;
			Map<String,List<String>> finalMap= new LinkedHashMap<String,List<String>>();
			Set<String> suspiciousAccounts = new HashSet<String>();

			while((transaction = br1.readLine())!= null) {
			StringTokenizer transactionfields = new StringTokenizer(transaction,"|");
			int j=0;String month="";
			String transactionId="",FromAccount="",ToAccount;
				while(transactionfields.hasMoreTokens()) {
					if (i>0) {
						if(j==0) {
							transactionId = transactionfields.nextToken();
						}
						else if(j==1) {
							month = transactionfields.nextToken();
						}
						else if(j==2) {
							FromAccount = transactionfields.nextToken();
						}
						else if(j==3) {
							ToAccount = transactionfields.nextToken();
							 boolean suspicious = customerTokenizer(FromAccount,ToAccount);
							
							if(suspicious == true) {
								suspiciousAccounts.add(FromAccount);
								suspiciousAccounts.add(ToAccount);
								StringTokenizer monthfields = new StringTokenizer(month,"-");
								int k=0;
								while(monthfields.hasMoreTokens()) {
									if(k==1) {
										String finalmonth = monthfields.nextToken();
										if(!(finalMap.containsKey(finalmonth))) {
											finalMap.put(finalmonth, new ArrayList<String>());
										}
										
										finalMap.get(finalmonth).add(transactionId);
										k++;
									}
									else {
										monthfields.nextToken();
										k++;
									}
								}
							}
							
						}
						else {
							transactionfields.nextToken();
						}	
						j++;	
					}
					else {
						transactionfields.nextToken();
					}
				}
				i++;
				sb1.append(transaction);
				sb1.append("\n");
			}

			List<String> susTransacMonthWise;
			System.out.println("-----------------------------------");
			 for (String key : finalMap.keySet()) {
				 System.out.println("For the month of "+ key + ":");
				 System.out.println("Suspicious Transactions :");
				 susTransacMonthWise=finalMap.get(key);
				 for(String susTransac : susTransacMonthWise) {
					 System.out.println(susTransac);
				 }
			     System.out.println();
			    }
			 System.out.println("-----------------------------------");
			 System.out.println("Suspicious Accounts: ");
			 for(String susAcc : suspiciousAccounts) {
				 System.out.println(susAcc);
			 }
			 System.out.println("-----------------------------------");
			
			br1.close();
			
		} catch(IOException e) {
			System.out.println("Customer File Not Found");
			e.printStackTrace();
			
		}
	}

	public static void main(String[] args) {
		suspiciousTransactions();

	}

}
