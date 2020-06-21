package com.instanceofcake.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMessageRuleEngine {

	@Test
	public void testRuleWithoutFileWriting() {
		MessageRuleEngine ruleEngine = new MessageRuleEngine();
		ruleEngine.registerRule(new ReplacementRule());
	
		MessageParser messageParser = new MessageParser();
		String filePath = "input/132443509.txt";
		Message inputMessage = messageParser.inputMessageParser(filePath);
		Message actualTransformedMessage = ruleEngine.rule(inputMessage);
		assertEquals("user2@domain.net,user@domain.com", actualTransformedMessage.getTo());
		assertEquals("another_origin@somewhere", actualTransformedMessage.getFrom());
		assertEquals("Re: Re: Saying hi", actualTransformedMessage.getSubject());
		String bodyExpected = "Please don't do that just yet!\n";
		assertEquals(bodyExpected, actualTransformedMessage.getBody());

	}

	@Test
	public void testRuleWitFileWriting() {
		MessageRuleEngine ruleEngine = new MessageRuleEngine();
		ruleEngine.registerRule(new ReplacementRule());

		MessageParser messageParser = new MessageParser();
		String inputFilePath = "input/132443509.txt";
		String outputFilePath = "output/132443509.txt";
		Message inputMessage = messageParser.inputMessageParser(inputFilePath);
		Message actualTransformedMessage = ruleEngine.rule(inputMessage);
		messageParser.outputMessageParser(outputFilePath, actualTransformedMessage);

	}

}
