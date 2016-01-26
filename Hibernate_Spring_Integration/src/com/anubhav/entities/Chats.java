package com.anubhav.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Component
@Entity
public class Chats {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int chatid;
	private String chatuser;
	private String chatmessage;
	public int getChatid() {
		return chatid;
	}
	public void setChatid(int chatid) {
		this.chatid = chatid;
	}
	public String getChatuser() {
		return chatuser;
	}
	public void setChatuser(String chatuser) {
		this.chatuser = chatuser;
	}
	public String getChatmessage() {
		return chatmessage;
	}
	public void setChatmessage(String chatmessage) {
		this.chatmessage = chatmessage;
	}
}
