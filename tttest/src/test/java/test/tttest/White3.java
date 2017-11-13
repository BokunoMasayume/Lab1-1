package test.tttest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class White3 {
	public TestListG G=new TestListG();
   
	@Before
	public void setUp() throws Exception {
		G=TestListG.createDirectedGraph("test001.txt");
	}
	@Test
	public void testqueryBridgeWords() {
		assertEquals("No bridge words from word1 to word2!",TestListG.queryBridgeWords(G,"feeling","strange"));
	}

}
