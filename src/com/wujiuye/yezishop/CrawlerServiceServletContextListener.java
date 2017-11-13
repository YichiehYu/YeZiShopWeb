package com.wujiuye.yezishop;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * tomcat服务启动监听
 *
 * @author wjy
 *
 */
public class CrawlerServiceServletContextListener implements ServletContextListener{

	/**
	 * 当Servlet 容器启动Web 应用时调用该方法。在调用完该方法之后，容器再对Filter 初始化， 
	 * 并且对那些在Web 应用启动时就需要被初始化的Servlet 进行初始化。 
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateManager.getHibernateManager().openSessionFactory();
		HibernateManager.getHibernateManager().getDefaultSession();
	}
	
	/**
	 * 当Servlet 容器终止Web 应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet 和Filter 过滤器。 
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateManager.getHibernateManager().closeSessionFactory();
		HibernateManager.getHibernateManager().closeDefaultSession();
	}

}
