package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
public class TransactionTest {
	 @Before 
	 public void setUp() {
      PowerMockito.mockStatic(DateProvider.class);
      PowerMockito.when(DateProvider.getInstance().thenReturn(new Date());
   }
	
    @Test
    public void transaction() {
		// we need to use mockito(testNG)/powerMock(JUnit) as DateProvider has a static method , we will mock it
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
    }
}
