package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import lab7.CreateDirectedGraph;
import lab7.QueryBridgeWords;
import lab7.TestListG;


public class WhiteCase2 {
	TestListG G=new TestListG();
	@Before
	public void setup()
	{
		G=new CreateDirectedGraph().createDirectedGraph("test001.txt");
	}
	@Test
	public void test() {
		new QueryBridgeWords();
		assertEquals("No word1 or word2 in the graph!",QueryBridgeWords.queryBridgeWords(G,"too","of"));
	}

}
