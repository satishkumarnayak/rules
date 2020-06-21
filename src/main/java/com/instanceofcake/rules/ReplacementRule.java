package com.instanceofcake.rules;

public class ReplacementRule implements Rule<Message, Message> {

	@Override
	public boolean matches(Message input) {

		return input.getTo().contains("domain.com");

	}

	@Override
	public Message process(Message input) {
		Message output = new Message(input);
		String replaceDollarWithE = input.getBody().replace('$', 'e');
		String replaceCarrotWithY = replaceDollarWithE.replace('^', 'y');
		String replaceAmpWithU = replaceCarrotWithY.replace('&', 'u');

		output.setBody(replaceAmpWithU);
		return output;
	}

	
}
