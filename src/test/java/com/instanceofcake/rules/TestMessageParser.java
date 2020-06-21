package com.instanceofcake.rules;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestMessageParser {

	@Test
	public void testMessageParser1() {
		MessageParser messageParser = new MessageParser();
		String filePath = "input/132443500.txt";
		Message actualParsedMessage = messageParser.inputMessageParser(filePath);
		assertEquals("user@domain.net,user2@domain2.org", actualParsedMessage.getTo());
		assertEquals("origin@somewhere.tv", actualParsedMessage.getFrom());
		assertEquals("Saying hi", actualParsedMessage.getSubject());
		String bodyExpected = "Hi someone,\n" + "\n" + "just wanted to say hi.\n" + "\n" + "Bye!" + "\n";
		assertEquals(bodyExpected, actualParsedMessage.getBody());

	}
	
	@Test
	public void testMessageParser2() {
		MessageParser messageParser = new MessageParser();
		String filePath = "input/132443504.txt";
		Message actualParsedMessage = messageParser.inputMessageParser(filePath);
		assertEquals("user@domain.net,user2@domain2.org", actualParsedMessage.getTo());
		assertEquals("origin2@somewhere.info", actualParsedMessage.getFrom());
		assertEquals("Re: Saying hi", actualParsedMessage.getSubject());
		String bodyExpected = "^eH ,uo^\n" + 
				"\n" + 
				"s'ereh ruoy :rebmun .0782349201\n" + 
				"esa$lP tel wonk woh ti .seog\n";
		assertEquals(bodyExpected, actualParsedMessage.getBody());

	}
	
	@Test
	public void testMessageParser3() {
		MessageParser messageParser = new MessageParser();
		String filePath = "input/132443500.txt";
		Message actualParsedMessage = messageParser.inputMessageParser(filePath);
		assertEquals("user@domain.net,user2@domain2.org", actualParsedMessage.getTo());
		assertEquals("origin@somewhere.tv", actualParsedMessage.getFrom());
		assertEquals("Saying hi", actualParsedMessage.getSubject());
		String bodyExpected = "Hi someone,\n" + "\n" + "just wanted to say hi.\n" + "\n" + "Bye!" + "\n";
		assertEquals(bodyExpected, actualParsedMessage.getBody());

	}
	
	@Test
	public void testMessageParser4() {
		MessageParser messageParser = new MessageParser();
		String filePath = "input/132443509.txt";
		Message actualParsedMessage = messageParser.inputMessageParser(filePath);
		assertEquals("user2@domain.net,user@domain.com", actualParsedMessage.getTo());
		assertEquals("another_origin@somewhere", actualParsedMessage.getFrom());
		assertEquals("Re: Re: Saying hi", actualParsedMessage.getSubject());
		String bodyExpected = "Pl$as$ don't do that j&st ^$t!\n";
		assertEquals(bodyExpected, actualParsedMessage.getBody());

	}

	@Test
	public void testMessageParserForWrite() {
		MessageParser messageParser = new MessageParser();
		String filePath = "input/132443500.txt";
		Message actualParsedMessage = messageParser.inputMessageParser(filePath);
		String actualStringMessage = actualParsedMessage.toStringForFileWrite();
		String expectedStringMessage = "To:user@domain.net,user2@domain2.org\n" + 
				"From:origin@somewhere.tv\n" + 
				"Subject:Saying hi\n" + 
				"Body:\n" + 
				"Hi someone,\n" + 
				"\n" + 
				"just wanted to say hi.\n" + 
				"\n" + 
				"Bye!\n" + 
				"";
		assertEquals(expectedStringMessage, actualStringMessage);
	}
}
