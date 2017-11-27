package test;

import static org.junit.Assert.*;

import org.junit.Test;

import lab7.QueryBridgeWords;


public class WhiteCase1 {

	@Test
	public void test() {
		new QueryBridgeWords();
		assertEquals("",QueryBridgeWords.queryBridgeWords(null,"too","of"));
	}

}
