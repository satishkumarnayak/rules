package com.instanceofcake.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReplacementRule {

	@Test
	public void testReplacementRule() {
		MessageParser messageParser = new MessageParser();
		String filePath = "input/132443509.txt";
		Message inputMessage = messageParser.inputMessageParser(filePath);

		ReplacementRule replacementRule = new ReplacementRule();

		boolean actualMatch = replacementRule.matches(inputMessage);
		assertTrue(actualMatch);

		Message actualProcessedMessage = replacementRule.process(inputMessage);
		assertEquals("user2@domain.net,user@domain.com", actualProcessedMessage.getTo());
		assertEquals("another_origin@somewhere", actualProcessedMessage.getFrom());
		assertEquals("Re: Re: Saying hi", actualProcessedMessage.getSubject());
		String bodyExpected = "Please don't do that just yet!\n";
		assertEquals(bodyExpected, actualProcessedMessage.getBody());
	}

}
