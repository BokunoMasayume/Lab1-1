package test.tttest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class White2 {
	public TestListG G=new TestListG();
   
	@Before
	public void setUp() throws Exception {
		G=TestListG.createDirectedGraph("test001.txt");
	}
	@Test
	public void testqueryBridgeWords() {
		assertEquals("No word1 or word2 in the graph!",TestListG.queryBridgeWords(G,"too","of"));
	}

}
