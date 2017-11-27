package test;

import static org.junit.Assert.*;

import org.junit.Test;

import lab7.QueryBridgeWords;
import lab7.TestListG;

import org.junit.Before;


public class BlackCase1 {
	public TestListG G=new TestListG();
	@Before
	public void setUp() throws Exception {
		G=null;
	}
	
	@Test
	public void testgenerateNewText() {
		assertEquals("",QueryBridgeWords.generateNewText(G, "Too strange worlds"));
	}

}
