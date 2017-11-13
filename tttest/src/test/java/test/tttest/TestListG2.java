package test.tttest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListG2 {
	public TestListG G=new TestListG();
	@Before
	public void setUp() throws Exception {
		G=TestListG.createDirectedGraph("test001.txt");
		TestListG.showDirectedGraph(G);
	}

	@Test
	public void testqueryBridgeWords() {
		String expected1="The bridge words from word1 to word2 are:";
		assertEquals(expected1+"seek get ",TestListG.queryBridgeWords(G, "too","out"));		
	}
}
