package com.wujiuye.yezishop.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wujiuye.yezishop.HibernateManager;
import com.wujiuye.yezishop.api.ResponseJsonResult.StateMessageKeyEnum;
import com.wujiuye.yezishop.bean.ClassBean;
import com.wujiuye.yezishop.bean.MerchandiseBean;
import com.wujiuye.yezishop.utils.StringUtils;

/**
 * 商品搜索，1.根据关键词搜索 2.根据分类搜索
 * 
 * @author wjy
 *
 */
public class MerchSearchAction extends BaseAction {

	private String type;// 搜索类型，根据关键词搜索:keyword 根据分类搜索:class
	private String keywordOrClass;// 关键词或分类名
	private int page;// 分页的页数
	private final int PAGE_COUNT = 10;// 每页10条数据

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeywordOrClass() {
		return keywordOrClass;
	}

	public void setKeywordOrClass(String keywordOrClass) {
		this.keywordOrClass = keywordOrClass;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 搜索
	 * 
	 * @return
	 */
	public String search() {
		List<MerchandiseBean> result = new ArrayList<>();
		Session session = HibernateManager.getHibernateManager().getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		if ("keyword".equals(this.type) && !StringUtils.isEmpty(keywordOrClass)) {
			result = searchWithKeyword(keywordOrClass, session);
		} else if ("class".equals(this.type) && !StringUtils.isEmpty(keywordOrClass)) {
			@SuppressWarnings("unchecked")
			List<ClassBean> classes = session.createQuery("from ClassBean c where c.name=:className")
					.setString("className", keywordOrClass).list();
			if (classes != null && classes.size() > 0) {
				result = searchWithClass(classes.get(0), session);
			}
		} else {
			this.result = ResponseJsonResult.getResponseStateJsonResult(this.getCurrentRequestUrl("search"),
					StateMessageKeyEnum.PARAMETER_NOTNULL);
			ResponseJsonResult.getDataMap(this.result).clear();
			return JSON;
		}
		this.result = ResponseJsonResult.getResponseStateJsonResult(this.getCurrentRequestUrl("search"),
				StateMessageKeyEnum.SUCCESS);
		Map<String, Object> data = (Map<String, Object>) ResponseJsonResult.getDataMap(this.result);
		data.clear();
		data.put("merchlist", result == null ? new ArrayList<>() : result);
		transaction.commit();
		return JSON;
	}

	/**
	 * 根据分类搜索
	 * 
	 * @param clas
	 *            分类
	 * @return
	 */
	private List<MerchandiseBean> searchWithClass(ClassBean clas, Session session) {
//		int count = getSerchResultCountSize(session, 2,
//				"select count(*) from MerchandiseBean mech where mech.clas=:clas", clas);
//		int maxPage = (count % PAGE_COUNT == 0 ? count / PAGE_COUNT : count / PAGE_COUNT + 1);
		List<MerchandiseBean> data = session.createQuery("from MerchandiseBean mech where mech.clas=:clas")
				.setEntity("clas", clas).setFirstResult(page-1 < 0 ? 0 : page*PAGE_COUNT)
				.setMaxResults(PAGE_COUNT).list();
		for (MerchandiseBean merch : data) {
			merch.getColorSize().toString();
			merch.getClas().toString();
			merch.getImages().toString();
			merch.getParameter().toString();
		}
		return data;
	}

	/**
	 * 根据关键词搜索
	 * 
	 * @param keyword
	 *            关键词
	 * @return
	 */
	private List<MerchandiseBean> searchWithKeyword(String keyword, Session session) {
//		int count = getSerchResultCountSize(session, 1,
//				"select count(*) from MerchandiseBean mech where mech.merchName like '%" + keyword + "%'\"", null);
//		int maxPage = (count % PAGE_COUNT == 0 ? count / PAGE_COUNT : count / PAGE_COUNT + 1);
		List<MerchandiseBean> data = session
				.createQuery("from MerchandiseBean mech where mech.merchName like '%" + keyword + "%'")
				.setFirstResult(page-1 < 0 ? 0 : page*PAGE_COUNT).setMaxResults(PAGE_COUNT).list();
		for (MerchandiseBean merch : data) {
			merch.getColorSize().toString();
			merch.getClas().toString();
			merch.getImages().toString();
			merch.getParameter().toString();
		}
		return data;
	}

//	/**
//	 * 获取搜索结果的总数
//	 * 
//	 * @param sql
//	 * @param session
//	 * @return
//	 */
//	private int getSerchResultCountSize(Session session, int type, String sql, ClassBean clas) {
//		try {
//			if (type == 1)
//				return Integer.valueOf(session.createQuery(sql).list().get(0).toString());
//			else if(type == 2){
//				return Integer.valueOf(session.createQuery(sql).setEntity("clas", clas).list().get(0).toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}

	@Override
	protected String setCurrentActionUrl() {
		return "/MerchSerchAction";
	}

}
