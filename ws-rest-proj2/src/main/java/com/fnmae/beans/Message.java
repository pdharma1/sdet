package com.fnmae.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

	private String text = "";
	private String author = "";
	private String date;
	private int id = 0;

	private String dateFormatter(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		return sdf.format(date);
	}

	// public Message(String text, String author, String date, int id) {
	// super();
	// this.text = text;
	// this.author = author;
	// this.date = date;
	// this.id = id;
	// }

	@Override
	public String toString() {
		return "Message [text=" + text + ", author=" + author + ", date=" + date + ", id=" + id + "]";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
