package SecureBank;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import SecureBank.Bank;
class TestBank {

	@Test
	void testSingleTransaction() {
		System.out.println("test case to find if the current transaction is supicious");
		assertEquals(true,Bank.customerTokenizer("10010589", "80074567"));
		assertEquals(false,Bank.customerTokenizer("68748963", "30045721"));
	}
	

}
