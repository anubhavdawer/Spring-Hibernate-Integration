package com.anubav.dto;

/**
 * This is a Dto class 
 * @author adawer
 *
 */
public class ChatsDto {

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
