package com.instanceofcake.rules;

public class Message {
	private String to;
	private String from;
	private String subject;
	private String body;

	public Message() {
		super();
	}

	public Message(Message msg) {
		this.to = msg.getTo();
		this.from = msg.getFrom();
		this.subject = msg.getSubject();
		this.body = msg.getBody();

	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Message [to=" + to + ", from=" + from + ", subject=" + subject + ", body=" + body + "]";
	}

	public String toStringForFileWrite() {
		StringBuilder output = new StringBuilder();

		output.append("To:" + this.to).append("\n").append("From:" + this.from).append("\n")
				.append("Subject:" + this.subject).append("\n").append("Body:").append("\n").append(this.getBody());

		return output.toString();

	}

}
