package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import lab7.CreateDirectedGraph;
import lab7.QueryBridgeWords;
import lab7.TestListG;


public class WhiteCase3 {
	TestListG G=new TestListG();
	@Before
	public void setup()
	{
		G=new CreateDirectedGraph().createDirectedGraph("test001.txt");
	}
	@Test
	public void test() {
		new QueryBridgeWords();
		assertEquals("No bridge words from word1 to word2!",QueryBridgeWords.queryBridgeWords(G,"feeling","strange"));

	}

}
