package test.tttest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListG5 {
	public TestListG G=new TestListG();
	@Before
	public void setUp() throws Exception {
		G=TestListG.createDirectedGraph("test001.txt");
	}

	@Test
	public void testgenerateNewText() {
		String str1="too seek out ";
		String str2="too get out ";
		
		if ((TestListG.generateNewText(G,"too out")==str1)||(TestListG.generateNewText(G,"too out")==str2))
		{
			assertNotNull(1);
		}
		
	}
}
