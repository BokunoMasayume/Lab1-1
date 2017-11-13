package test.tttest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListG6 {
	public TestListG G=new TestListG();
	@Before
	public void setUp() throws Exception {
		G=TestListG.createDirectedGraph("test001.txt");
		TestListG.showDirectedGraph(G);
	}
	@Test
	public void testqueryBridgeWords() {
		String expected="No bridge words from word1 to word2!";
		assertEquals(expected,TestListG.queryBridgeWords(G, "come","out"));		
	}
}
