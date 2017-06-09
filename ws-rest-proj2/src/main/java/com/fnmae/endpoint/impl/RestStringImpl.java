package com.fnmae.endpoint.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fnmae.beans.Message;
import com.fnmae.dal.MessageDal;

public class RestStringImpl {

	public List<Message> deleteMessagesByAuthor(String author) {

		List<Message> messages = new ArrayList<Message>();
		Map<Integer, Message> messageMap = new HashMap<Integer, Message>();
		messageMap = MessageDal.getMessageMap();

		System.out.println("Delete implementor hit");

		Iterator mIterator = messageMap.values().iterator();

		while (mIterator.hasNext()) {
			Message message = (Message) mIterator.next();
			if (message.getAuthor().contains(author)) {
				messages.add(message);
				mIterator.remove();
			}
		}

		return messages;
	}

	public List<Message> getMessagesByAuthor(String author) {

		List<Message> messages = new ArrayList<Message>();
		Map<Integer, Message> messageMap = new HashMap<Integer, Message>();
		messageMap = MessageDal.getMessageMap();

		System.out.println("Get Message by Author implementor hit");

		Iterator mIterator = messageMap.values().iterator();

		while (mIterator.hasNext()) {
			Message message = (Message) mIterator.next();
			if (message.getAuthor().contains(author)) {
				messages.add(message);
			}
		}

		MessageDal.setMessageMap(messageMap);
		return messages;
	}
}
