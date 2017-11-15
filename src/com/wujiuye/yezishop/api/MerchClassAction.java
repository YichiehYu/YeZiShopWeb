package com.wujiuye.yezishop.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wujiuye.yezishop.HibernateManager;
import com.wujiuye.yezishop.WebConfig;
import com.wujiuye.yezishop.api.ResponseJsonResult.StateMessageKeyEnum;
import com.wujiuye.yezishop.bean.ClassBean;
import com.wujiuye.yezishop.utils.StringUtils;

/**
 * 商品分类接口
 * 
 * @author wjy
 *
 */
public class MerchClassAction extends BaseAction {

	private List<ClassBean> classlist = new ArrayList<>();

	/**
	 * 获取全部分类
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getMerchClass() {
		if (this.classlist==null || classlist.size() == 0) {
			Session session = HibernateManager.getHibernateManager().getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			/**
			 * 迫切和非迫切： 非迫切返回结果是Object[] 迫切连接返回的结果是对象 + fetch
			 */
			List<ClassBean> tmpClassList = session
					.createQuery("from ClassBean child left join fetch child.parentsClass").list();
			transaction.commit();
			session.close();
			for (ClassBean bean : tmpClassList) {
				// 修改图片地址为详细地址
				if (!StringUtils.isEmpty(bean.getImgUrl())) {
					String imgUrl = WebConfig.PUBLIC_STATIC_IMAGES_ROOT + bean.getImgUrl();
					bean.setImgUrl(imgUrl);
				}
			}
			this.classlist = tmpClassList;
		}
		this.result = ResponseJsonResult.getResponseStateJsonResult(this.getCurrentRequestUrl("getMerchClass"),
				StateMessageKeyEnum.SUCCESS);
		Map<String, Object> data = (Map<String, Object>) ResponseJsonResult.getDataMap(this.result);
		data.clear();
		data.put("classlist", this.classlist);
		return JSON;
	}

	@Override
	protected String setCurrentActionUrl() {
		return "/MerchClassAction";
	}

}
