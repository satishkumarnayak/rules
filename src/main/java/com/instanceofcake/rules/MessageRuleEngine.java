package com.instanceofcake.rules;

import java.util.ArrayList;
import java.util.List;

public class MessageRuleEngine {
	List<Rule<Message, Message>> rules;

	public MessageRuleEngine() {
		rules = new ArrayList<>();
	}

	public Message rule(Message message) {
		return rules.stream()
				.filter(rule -> rule.matches(message))
				.map(rule -> rule.process(message)).findFirst()
				.orElseThrow(() -> new RuntimeException("No Matching rule found"));
	}

	public MessageRuleEngine registerRule(Rule<Message, Message> rule) {
		rules.add(rule);
		return this;
	}

}
