package test.tttest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListG1 {
	public TestListG G=new TestListG();
	@Before
	public void setUp() throws Exception {
		G=TestListG.createDirectedGraph("test001.txt");
		TestListG.showDirectedGraph(G);
	}
	@Test
	public void testqueryBridgeWords() {
		String expected1="The bridge words from word1 to word2 are:";
		assertEquals(expected1+"explore ",TestListG.queryBridgeWords(G, "too","strange"));		
	}
}
