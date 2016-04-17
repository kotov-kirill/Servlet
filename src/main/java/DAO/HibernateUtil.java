package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Rakov Kirill
 */

public class HibernateUtil {
    private static SessionFactory sessionFactory1 = null;
    private static SessionFactory sessionFactory2 = null;
    static {
        try {
            sessionFactory1 = new Configuration().configure("hibernatesqlite1.cfg.xml").buildSessionFactory();
            sessionFactory2 = new Configuration().configure("hibernateoracle.cfg.xml").buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    public static SessionFactory getSessionFactory1(){
        return sessionFactory1;
    }
    public static Session getSession1(){
        Session session1 = null;
        try {
            session1 = getSessionFactory1().openSession();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return session1;
    }
    public static SessionFactory getSessionFactory2(){
        return sessionFactory2;
    }
    public static Session getSession2(){
        Session session2 = null;
        try {
            session2 = getSessionFactory2().openSession();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return session2;
    }
    public static void closeSession(Session session){
        if(session != null && session.isOpen()){
            session.close();
        }
    }
}