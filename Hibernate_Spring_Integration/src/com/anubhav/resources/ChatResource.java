package com.anubhav.resources;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.anubhav.dao.ChatsDao;
import com.anubhav.entities.Chats;

/**
 * This class loads the applicationContext and calls Dao class which has the
 * logic to save the object of chats
 * 
 * @author adawer
 *
 */
@Component
public class ChatResource {

	// Create an instance of the entity
	Chats chats = new Chats();

	// Injecting Dao bean

	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Autowired
	ChatsDao dao = (ChatsDao) appContext.getBean("ChatsDao");

	/**
	 * No need to create a session factory, its already been taken care of in
	 * the applicationContext Load the application context and it will create
	 * the beans for data source, session factory and dao Data source-->
	 * SessionFactoryBean-->Dao
	 */

	public void saveMethod() {
		chats.setChatuser("Spring3");
		chats.setChatmessage("spring integrated successfully");
		dao.saveChat(chats);
		System.out.println("success");
	}

	/**
	 * Updates chat message for the particular chatUSer
	 * 
	 * @param user
	 */
	public void updateMethod(String user) {

		chats = dao.findByUser(user);
		chats.setChatmessage("message updated again");
		dao.updateChat(chats);
		System.out.println("chat updated");
	}

	/**
	 * Deletes chat for this chatUser
	 * 
	 * @param user
	 */
	public void deleteMethod(String user) {
		chats = dao.findByUser(user);
		dao.deleteChat(chats);
		System.out.println("chat successfully deleted");
	}

	/**
	 * Get all the chats from the database
	 */
	public void displayChats() {
		List list = dao.displayChats();
		Iterator ite = list.iterator();
		while (ite.hasNext()) {
			chats = (Chats) ite.next();
			System.out.println("chatId is:" + chats.getChatid());
			System.out.println("chatMessage is:" + chats.getChatmessage());
			System.out.println("chatUser id:" + chats.getChatuser());
			System.out.println('\n');
		}
	}

	public static void main(String[] args) {

		ChatResource res = new ChatResource();
		// res.saveMethod();
		// res.updateMethod("ron");
		// res.deleteMethod("ron");
		res.displayChats();
	}
}