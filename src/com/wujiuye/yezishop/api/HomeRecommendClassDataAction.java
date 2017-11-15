package com.wujiuye.yezishop.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wujiuye.yezishop.HibernateManager;
import com.wujiuye.yezishop.api.ResponseJsonResult.StateMessageKeyEnum;
import com.wujiuye.yezishop.bean.RecommendClassBean;
import com.wujiuye.yezishop.bean.RecommendClassDataBean;

public class HomeRecommendClassDataAction extends BaseAction{

	private List<List<RecommendClassDataBean>> homeRecommendClassData = new ArrayList<>();

	/**
	 * 获取全部分类
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getHomeRecommendClassData() {
		if (this.homeRecommendClassData==null || homeRecommendClassData.size() == 0) {
			Session session = HibernateManager.getHibernateManager().getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			//分组查询，获取所有推荐数据的分组
			List<RecommendClassBean> groupList = session
					.createQuery("select rcd.recommendClass from RecommendClassDataBean as rcd group by rcd.recommendClass")
					.list();
			//获取分组数据
			List<List<RecommendClassDataBean>> resultList = new ArrayList<>();
			for(RecommendClassBean group : groupList) {
				List<RecommendClassDataBean> groupRecomdendList = session
						.createQuery("from RecommendClassDataBean as rcd left join fetch rcd.recommendClass left join fetch rcd.merchandise where rcd.recommendClass=:rcBean")
						.setEntity("rcBean", group)
						.list();
				if(groupRecomdendList!=null)
					resultList.add(groupRecomdendList);
			}
			this.homeRecommendClassData = resultList;
			//解决懒加载
			for(List<RecommendClassDataBean> group:this.homeRecommendClassData) {
				for(RecommendClassDataBean item:group) {
					item.getMerchandise().toString();
				}
			}
			transaction.commit();
			session.close();
		}
		this.result = ResponseJsonResult.getResponseStateJsonResult(this.getCurrentRequestUrl("getHomeRecommendClassData"),
				StateMessageKeyEnum.SUCCESS);
		Map<String, Object> data = (Map<String, Object>) ResponseJsonResult.getDataMap(this.result);
		data.clear();
		data.put("homeRecommendClassData", this.homeRecommendClassData);
		return JSON;
	}
	
	@Override
	protected String setCurrentActionUrl() {
		return "/HomeRecommendClassDataAction";
	}

}
