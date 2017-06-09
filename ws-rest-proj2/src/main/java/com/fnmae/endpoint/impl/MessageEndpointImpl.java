package com.fnmae.endpoint.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fnmae.beans.Message;
import com.fnmae.dal.MessageDal;

public class MessageEndpointImpl {

	public List<Message> getAllMessages() {
		Map<Integer, Message> messageMap = new HashMap<Integer, Message>();
		messageMap = MessageDal.getMessageMap();
		List<Message> messages = new ArrayList<Message>();
		Set<Integer> m1 = messageMap.keySet();
		for (Integer i : m1) {
			messages.add(messageMap.get(i));
		}

		return messages;
	}

	public Message getMessageById(int id) {
		Map<Integer, Message> messageMap = new HashMap<Integer, Message>();
		messageMap = MessageDal.getMessageMap();
		return messageMap.get(id);
	}

	public Message saveMessage(Message message) {
		Map<Integer, Message> messageMap = new HashMap<Integer, Message>();
		messageMap = MessageDal.getMessageMap();
		messageMap.put(message.getId(), message);
		MessageDal.setMessageMap(messageMap);
		return getMessageById(message.getId());
	}

	public Message updateMessage(Message message) {
		Map<Integer, Message> messageMap = new HashMap<Integer, Message>();
		messageMap = MessageDal.getMessageMap();
		messageMap.put(message.getId(), message);
		MessageDal.setMessageMap(messageMap);
		return getMessageById(message.getId());
	}

	public Message deleteMessage(int id) {
		Map<Integer, Message> messageMap = new HashMap<Integer, Message>();
		messageMap = MessageDal.getMessageMap();
		Message message = messageMap.remove(id);
		MessageDal.setMessageMap(messageMap);
		return message;
	}
}
