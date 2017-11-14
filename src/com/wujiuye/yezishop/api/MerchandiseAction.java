package com.wujiuye.yezishop.api;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wujiuye.yezishop.HibernateManager;
import com.wujiuye.yezishop.api.ResponseJsonResult.StateMessageKeyEnum;
import com.wujiuye.yezishop.bean.MerchandiseBean;

/**
 * 获取商品详情
 * 
 * @author wjy
 *
 */
public class MerchandiseAction extends BaseAction {

	private int merchId;// 商品id

	public int getMerchId() {
		return merchId;
	}

	public void setMerchId(int merchId) {
		this.merchId = merchId;
	}
	
	/**
	 * 根据商品id获取商品全部信息
	 * @return
	 */
	public String merchInfo() {
		if(merchId==0) {
			this.result = ResponseJsonResult.getResponseStateJsonResult("merchInfo", StateMessageKeyEnum.PARAMETER_NOTNULL);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		this.result = ResponseJsonResult.getResponseStateJsonResult("merchInfo", StateMessageKeyEnum.SUCCESS);
		Map<String,Object> data = ResponseJsonResult.getDataMap(result);
		data.clear();
		Session session = HibernateManager.getHibernateManager().getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		MerchandiseBean merch = session.get(MerchandiseBean.class, this.merchId);
		if(merch!=null) {
			data.put("merchandise", merch);
			merch.getColorSize().toString();
			merch.getImages().toString();
			merch.getParameter().toString();
			merch.getClas().toString();
		}
		transaction.commit();
		return JSON;
	}

	@Override
	protected String setCurrentActionUrl() {
		return "/MerchandiseAction";
	}

}
