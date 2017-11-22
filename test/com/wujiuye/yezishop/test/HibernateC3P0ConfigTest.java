package com.wujiuye.yezishop.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wujiuye.yezishop.HibernateManager;

/**
 * 测试hibernate c3p0配置是否成功
 * @author wjy
 *
 */
public class HibernateC3P0ConfigTest {

	@Before
	public void onStart() {
		HibernateManager.getHibernateManager().openSessionFactory();
	}
	
	@Test
	public void testC3p0() {
		Session session = HibernateManager.getHibernateManager().getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.doWork(new Work() {
			
			@Override
			public void execute(Connection arg0) throws SQLException {
				System.out.println(arg0);
			}
		});
	}
	
	@After
	public void onStop() {
		HibernateManager.getHibernateManager().closeSessionFactory();
	}
	
}
