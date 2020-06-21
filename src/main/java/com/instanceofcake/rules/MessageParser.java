package com.instanceofcake.rules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MessageParser {

	private String to;
	private String from;
	private String subject;
	private StringBuilder body;
	private Message inputMessage;

	public Message inputMessageParser(String filePath) {

		try {
			File myObj = new File(filePath);

			Scanner myReader = new Scanner(myObj);
			to = myReader.nextLine();

			from = myReader.nextLine();

			subject = myReader.nextLine();

			String skipBodykey = myReader.nextLine();
			body = new StringBuilder();

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();

				body.append(data);
				body.append("\n");
			}
			myReader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		inputMessage = new Message();
		inputMessage.setTo(to.substring(3));
		inputMessage.setFrom(from.substring(5));
		inputMessage.setSubject(subject.substring(8));
		inputMessage.setBody(body.toString());
		return inputMessage;

	}
	
	public void outputMessageParser(String filePath, Message message) {
		
		try {
			Files.write(Paths.get(filePath), message.toStringForFileWrite().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
