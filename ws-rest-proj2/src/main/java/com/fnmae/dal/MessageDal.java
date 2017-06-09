package com.fnmae.dal;

import java.util.HashMap;
import java.util.Map;

import com.fnmae.beans.Message;

public class MessageDal {

	private static Map<Integer, Message> messageMap = new HashMap<Integer, Message>();

	public static Map<Integer, Message> getMessageMap() {
		return messageMap;
	}

	public static void setMessageMap(Map<Integer, Message> messageMap) {
		MessageDal.messageMap = messageMap;
	}

	static {
		for (int i = 101; i < 107; i++) {
			int id = i;
			String author = "James [" + i + "]";
			String text = "Its beautiful [" + i + "] day outside, how is your day";
			String date = "23-FEB-2017";
			Message message = new Message();

			message.setAuthor(author);
			message.setDate(date);
			message.setId(id);
			message.setText(text);

			messageMap.put(id, message);
		}
	}

}
