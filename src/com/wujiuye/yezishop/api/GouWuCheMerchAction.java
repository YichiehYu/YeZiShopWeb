package com.wujiuye.yezishop.api;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wujiuye.yezishop.HibernateManager;
import com.wujiuye.yezishop.api.ResponseJsonResult.StateMessageKeyEnum;
import com.wujiuye.yezishop.bean.GwcMerchBean;
import com.wujiuye.yezishop.bean.MerchandiseBean;
import com.wujiuye.yezishop.utils.StringUtils;

/**
 * 购物车接口
 * 
 * @author wjy
 *
 */
public class GouWuCheMerchAction extends BaseAction {

	// 设备唯一标识
	private String derviceToken;
	// 设置操作系统
	private String derviceOS;
	// 商品id
	private int merchId;

	public String getDerviceToken() {
		return derviceToken;
	}

	public void setDerviceToken(String derviceToken) {
		this.derviceToken = derviceToken;
	}

	public String getDerviceOS() {
		return derviceOS;
	}

	public void setDerviceOS(String derviceOS) {
		this.derviceOS = derviceOS;
	}

	public int getMerchId() {
		return merchId;
	}

	public void setMerchId(int merchId) {
		this.merchId = merchId;
	}

	/**
	 * 加入购物车 请求参数1:merchId 请求参数2:derviceToken 请求参数3:derviceOS
	 * 
	 * @return
	 */
	public String joinGouWuChe() {
		if (merchId == 0 || StringUtils.isEmpty(derviceToken)) {
			this.result = ResponseJsonResult.getResponseStateJsonResult("joinGouWuChe",
					StateMessageKeyEnum.PARAMETER_NOTNULL);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}

		Session session = HibernateManager.getHibernateManager().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		MerchandiseBean merch = session.get(MerchandiseBean.class, this.merchId);
		if (merch != null && !isInGouWuChe(session, merch)) {
			// 保存记录到数据库
			GwcMerchBean gwc = new GwcMerchBean();
			gwc.setDateTime(System.currentTimeMillis() / 1000);
			gwc.setDerviceOS(derviceOS);
			gwc.setDerviceToken(derviceToken);
			gwc.setMerchandise(merch);
			session.save(gwc);
			this.result = ResponseJsonResult.getResponseStateJsonResult("joinGouWuChe", StateMessageKeyEnum.SUCCESS);
			Map<String, Object> data = ResponseJsonResult.getDataMap(result);
			data.clear();
		} else {
			this.result = ResponseJsonResult.getResponseStateJsonResult("joinGouWuChe", StateMessageKeyEnum.GWC_EXIST);
			Map<String, Object> data = ResponseJsonResult.getDataMap(result);
			data.clear();
		}
		transaction.commit();
		session.close();
		return JSON;
	}

	/**
	 * 判断是否已经在购物车了
	 * 
	 * @return
	 */
	private boolean isInGouWuChe(Session session, MerchandiseBean merch) {
		List<GwcMerchBean> beanList = session
				.createQuery("from GwcMerchBean where derviceToken=:derviceToken and merchandise=:merch")
				.setParameter("derviceToken", derviceToken).setParameter("merch", merch).list();
		if (beanList == null || beanList.size() == 0)
			return false;
		return true;
	}

	/**
	 * 获取我的购物车列表 参数1:derviceToken 参数2:derviceOS
	 * 
	 * @return
	 */
	public String myGouWuChe() {
		if (StringUtils.isEmpty(derviceToken)) {
			this.result = ResponseJsonResult.getResponseStateJsonResult("myGouWuChe",
					StateMessageKeyEnum.PARAMETER_NOTNULL);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		this.result = ResponseJsonResult.getResponseStateJsonResult("myGouWuChe", StateMessageKeyEnum.SUCCESS);
		Map<String, Object> data = ResponseJsonResult.getDataMap(result);
		data.clear();
		Session session = HibernateManager.getHibernateManager().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<GwcMerchBean> tmpList = session.createQuery("from GwcMerchBean gwc left join fetch gwc.merchandise")
				.list();
		for (GwcMerchBean gwc : tmpList)
			gwc.getMerchandise().toString();
		transaction.commit();
		session.close();
		data.put("gwcMerchList", tmpList);
		return JSON;
	}

	@Override
	protected String setCurrentActionUrl() {
		return "/GouWuCheMerchAction";
	}

}
