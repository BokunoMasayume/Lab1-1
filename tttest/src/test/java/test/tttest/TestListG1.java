package test.tttest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListG1 {
	public TestListG G=new TestListG();
	@Before
	public void setUp() throws Exception {
		G=null;
	}
	@Test
	public void testgenerateNewText() {
		assertEquals("",TestListG.generateNewText(G, "Too strange worlds"));		
	}
}
