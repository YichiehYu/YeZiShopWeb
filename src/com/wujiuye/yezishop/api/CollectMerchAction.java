package com.wujiuye.yezishop.api;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wujiuye.yezishop.HibernateManager;
import com.wujiuye.yezishop.api.ResponseJsonResult.StateMessageKeyEnum;
import com.wujiuye.yezishop.bean.CollectMerchBean;
import com.wujiuye.yezishop.bean.MerchandiseBean;

/**
 * 收藏 api
 * 
 * @author wjy
 *
 */
public class CollectMerchAction extends PermissionsAction {

	private String token;// 用户登录后获取的token
	private int merchId;// 需要收藏的商品的id

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getMerchId() {
		return merchId;
	}

	public void setMerchId(int merchId) {
		this.merchId = merchId;
	}

	/**
	 * 收藏商品
	 * 
	 * @return
	 */
	public String joinMyCollect() {
		if (!this.isLogin(token)) {
			this.result = ResponseJsonResult.getResponseStateJsonResult("joinMyCollect",
					StateMessageKeyEnum.USER_NOLOGIN);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		if (merchId <= 0) {
			this.result = ResponseJsonResult.getResponseStateJsonResult("joinMyCollect",
					StateMessageKeyEnum.PARAMETER_NOTNULL);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		Session session = HibernateManager.getHibernateManager().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		MerchandiseBean merch = session.get(MerchandiseBean.class, merchId);
		if (merch == null) {
			transaction.commit();
			session.close();
			this.result = ResponseJsonResult.getResponseStateJsonResult("joinMyCollect", StateMessageKeyEnum.ERROR);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		if (isCollectExsit(session, merch)) {
			transaction.commit();
			session.close();
			this.result = ResponseJsonResult.getResponseStateJsonResult("joinMyCollect",
					StateMessageKeyEnum.COLLECT_EXIST);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		CollectMerchBean coll = new CollectMerchBean();
		coll.setDataTime(System.currentTimeMillis() / 1000);
		coll.setMerch(merch);
		coll.setUser(getApiLoginUser());
		session.save(coll);
		transaction.commit();
		session.close();
		this.result = ResponseJsonResult.getResponseStateJsonResult("joinMyCollect", StateMessageKeyEnum.SUCCESS);
		Map<String, Object> data = ResponseJsonResult.getDataMap(result);
		data.clear();
		return JSON;
	}

	/**
	 * 判断商品是否已经收藏过了
	 * 
	 * @return
	 */
	private boolean isCollectExsit(Session session, MerchandiseBean merch) {
		List<CollectMerchBean> beanList = session.createQuery("from CollectMerchBean where merch=:merch and user=:user")
				.setParameter("merch", merch).setParameter("user", getApiLoginUser()).list();
		if (beanList == null || beanList.size() == 0)
			return false;
		return true;
	}

	/**
	 * 获取收藏的商品列表
	 * 
	 * @return
	 */
	public String myCollectList() {
		if (!this.isLogin(token)) {
			this.result = ResponseJsonResult.getResponseStateJsonResult("myCollectList",
					StateMessageKeyEnum.USER_NOLOGIN);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		Session session = HibernateManager.getHibernateManager().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<CollectMerchBean> beanList = session
				.createQuery("from CollectMerchBean where user=:user")
				.setParameter("user", getApiLoginUser()).list();
		this.result = ResponseJsonResult.getResponseStateJsonResult("myCollectList", StateMessageKeyEnum.SUCCESS);
		Map<String, Object> data = ResponseJsonResult.getDataMap(result);
		data.clear();
		for (CollectMerchBean collect : beanList) {
			collect.getUser().toString();
			collect.getMerch().toString();
		}
		transaction.commit();
		session.close();
		data.put("collectList", beanList);
		return JSON;
	}

	/**
	 * 取消收藏
	 * 
	 * @return
	 */
	public String delCollectWithMerchId() {
		if (!this.isLogin(token)) {
			this.result = ResponseJsonResult.getResponseStateJsonResult("delCollectWithMerchId",
					StateMessageKeyEnum.USER_NOLOGIN);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		if (merchId <= 0) {
			this.result = ResponseJsonResult.getResponseStateJsonResult("delCollectWithMerchId",
					StateMessageKeyEnum.PARAMETER_NOTNULL);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		Session session = HibernateManager.getHibernateManager().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		MerchandiseBean merch = session.get(MerchandiseBean.class, merchId);
		if (merch == null) {
			transaction.commit();
			session.close();
			this.result = ResponseJsonResult.getResponseStateJsonResult("delCollectWithMerchId",
					StateMessageKeyEnum.ERROR);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		// 删除收藏
		session.createQuery("delete from CollectMerchBean Where merch=:merch and user=:user")
				.setParameter("merch", merch).setParameter("user", getApiLoginUser()).executeUpdate();
		transaction.commit();
		session.close();
		this.result = ResponseJsonResult.getResponseStateJsonResult("delCollectWithMerchId",
				StateMessageKeyEnum.SUCCESS);
		Map<String, Object> data = ResponseJsonResult.getDataMap(result);
		data.clear();
		return JSON;
	}

	@Override
	protected String setCurrentActionUrl() {
		return "/CollectMerchAction";
	}

}
