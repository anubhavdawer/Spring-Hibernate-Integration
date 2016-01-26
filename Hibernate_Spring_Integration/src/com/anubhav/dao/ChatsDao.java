package com.anubhav.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.anubhav.entities.Chats;

/**
 * This class provides the hibernate-spring template which has the methods to
 * perform database operations
 * 
 * @author adawer
 *
 */
@Component
public class ChatsDao {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/**
	 * This method adds a new chat record in the database
	 * 
	 * @param chats
	 */
	public void saveChat(Chats chats) {
		template.save(chats);
	}

	/**
	 * This would update the chat message
	 * 
	 * @param chats
	 */
	public void updateChat(Chats chats) {

		template.update(chats);
	}

	/**
	 * This method finds the chat record based on the chatUser passed as an
	 * argument to this method
	 * 
	 * @param user
	 * @return
	 */
	public Chats findByUser(String user) {
		List list = template.find("from Chats where chatUser=?", user);
		return (Chats) list.get(0);
	}

	/**
	 * Deletes a chat by chat passing the chat object findbyUser method would be
	 * called before calling this method
	 * 
	 * @param chats
	 */
	public void deleteChat(Chats chats) {
		template.delete(chats);
	}

	/**
	 * This method finds all the chats and returns a list of all the objects
	 * 
	 * @return
	 */
	public List displayChats() {
		List list = template.find("from Chats");
		return list;
	}
}
