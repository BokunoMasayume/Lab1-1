package test.tttest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListG3 {
	public TestListG G=new TestListG();
	@Before
	public void setUp() throws Exception {
		G=TestListG.createDirectedGraph("test001.txt");
	}

	@Test
	public void testgenerateNewText() {
		assertEquals("too ",TestListG.generateNewText(G,"too"));		
	}
}
