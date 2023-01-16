package com.sms.util;


/*import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 public class UtilNew {
    private static SessionFactory SessionFactory;
    static {
        try {
            SessionFactory = new Configuration().configure().buildSessionFactory();
        }catch(Exception e) {
            System.out.println(e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return SessionFactory;
    }
}*/
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sms.entity.UserClass;


public class UtilNew {

	public static Session getSession() {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(UserClass.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
	}
}