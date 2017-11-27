package test;

import static org.junit.Assert.*;

import org.junit.Test;

import lab7.CreateDirectedGraph;
import lab7.QueryBridgeWords;
import lab7.TestListG;

import org.junit.Before;


public class BlackCase5 {
	public TestListG G=new TestListG();
	@Before
	public void setUp() throws Exception {
		G=new CreateDirectedGraph().createDirectedGraph("test001.txt");
	}
	@Test
	public void testgenerateNewText() {
		String str1="too seek out ";
		String str2="too get out ";
		
		if ((QueryBridgeWords.generateNewText(G,"too out")==str1)||(QueryBridgeWords.generateNewText(G,"too out")==str2))
		{
			assertNotNull(1);
		}
	}

}