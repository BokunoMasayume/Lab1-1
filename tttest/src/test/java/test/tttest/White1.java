package test.tttest;

import static org.junit.Assert.*;

import org.junit.Test;

public class White1 {
	public TestListG G=new TestListG();
   
	@Test
	public void testqueryBridgeWords() {
		assertEquals("",TestListG.queryBridgeWords(null,"too","of"));
	}

}
