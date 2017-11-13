package test.tttest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class White5 {
	public TestListG G=new TestListG();
   
	@Before
	public void setUp() throws Exception {
		G=TestListG.createDirectedGraph("test001.txt");
	}
	@Test
	public void testqueryBridgeWords() {
		assertEquals("The bridge words from word1 to word2 are:out ",TestListG.queryBridgeWords(G,"seek","new"));
	}

}
