1) Took the data from the files i.e. Transactions.txt and Customers.txt

2) Copy the file paths where you kept these both files and paste it in the code as i considered the full path of files in code.

3) Then to execute the file Bank.java:
	-> through cmd:
		javac Bank.java
		java Bank

	-> can execute through any ide, just by handling the 			   packages import and file path change.

4) For testing file to get executed, i have used the package name SecureBank in my workspace, you can just change the import in TestBank.java file if you have some other package name.

5) In my workspace i have considered the package SecureBank, but for sending the file, i have put the files in separate file, if you want to run the test file, you can make SecureBank Package and put all the files inside it.

6) If you are executing the files placing them into the package:
-> through cmd:
javac Bank.java
java -cp [Full path before the package] [packageName/className]

here / in packageName/className is mandatory as used for path.


7) I am attaching the output(screenshot) of the Program and Unit Test.