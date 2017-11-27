package test;

import static org.junit.Assert.*;

import org.junit.Test;

import lab7.CreateDirectedGraph;
import lab7.QueryBridgeWords;
import lab7.TestListG;

import org.junit.Before;


public class BlackCase6 {
	public TestListG G=new TestListG();
	@Before
	public void setUp() throws Exception {
		G=new CreateDirectedGraph().createDirectedGraph("test001.txt");
	}
	@Test
	public void testgenerateNewText() {
		assertEquals("new strange too ",QueryBridgeWords.generateNewText(G, "new strange too"));
	}

}