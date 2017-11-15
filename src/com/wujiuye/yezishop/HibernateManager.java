package com.wujiuye.yezishop;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateManager {

	private SessionFactory sessionFactory = null;
	private ServiceRegistry sessionRegistry = null;

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	private static HibernateManager mHibernateManager = null;

	private HibernateManager() {
	}

	public static HibernateManager getHibernateManager() {
		if (mHibernateManager == null) {
			mHibernateManager = new HibernateManager();
		}
		return mHibernateManager;
	}

	public void openSessionFactory() throws HibernateException {
		if (this.sessionRegistry == null || this.sessionFactory == null) {
			try {
				// 获取ServiceRegistry实例，
				this.sessionRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				// 获取SessionFactory实例，Session工厂，SessionFactory是线程安全的，一般一个应用程序只需要一个SessionFactory
				this.sessionFactory = new MetadataSources(this.sessionRegistry).buildMetadata().buildSessionFactory();
			} catch (HibernateException e) {
				e.printStackTrace();
				StandardServiceRegistryBuilder.destroy(this.sessionRegistry);
				throw e;
			}
		}
	}

	public HibernateManager closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
		return this;
	}

}
