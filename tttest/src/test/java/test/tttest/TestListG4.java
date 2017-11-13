package test.tttest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListG4 {
	public TestListG G=new TestListG();
	@Before
	public void setUp() throws Exception {
		G=TestListG.createDirectedGraph("test001.txt");
		TestListG.showDirectedGraph(G);
	}
	@Test
	public void testqueryBridgeWords() {
		String expected="No word1 or word2 in the graph!";
		assertEquals(expected,TestListG.queryBridgeWords(G, "none","of"));		
	}
}
