package com.anubhav.util;

import org.hibernate.SessionFactory;

public class CustomHibernateDaoSupport extends org.springframework.orm.hibernate3.support.HibernateDaoSupport {

	public void method(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
		}
	}