package com.wujiuye.yezishop.api;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wujiuye.yezishop.HibernateManager;
import com.wujiuye.yezishop.api.ResponseJsonResult.StateMessageKeyEnum;
import com.wujiuye.yezishop.bean.ApiUserBean;
import com.wujiuye.yezishop.utils.Base64Utils;
import com.wujiuye.yezishop.utils.StringUtils;

/**
 * 用户登录 目前仅实现第三方登录
 * 
 * @author wjy
 *
 */
public class UserLoginAction extends BaseAction implements SessionAware{

	private String openid;// 第三方opendid
	private String nickname;// 第三方昵称
	private String face;// 第三方获取的头像
	private int sex;// 性别,0为男1为女
	private String access_token;// 第三方获取的access_token
	private String api_platform;// 那个平台:"QQ","WEIXIN"
	
	private Map<String,Object> userSession;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getApi_platform() {
		return api_platform;
	}

	public void setApi_platform(String api_platform) {
		this.api_platform = api_platform;
	}

	/**
	 * 第三方登录
	 * 
	 * @return
	 */
	public String apiLogin() {
		if (StringUtils.isEmpty(openid) || StringUtils.isEmpty(nickname) || StringUtils.isEmpty(face)
				|| StringUtils.isEmpty(access_token) || StringUtils.isEmpty(api_platform)) {
			this.result = ResponseJsonResult.getResponseStateJsonResult("apiLogin",
					StateMessageKeyEnum.PARAMETER_NOTNULL);
			ResponseJsonResult.getDataMap(result).clear();
			return JSON;
		}
		Session session = HibernateManager.getHibernateManager().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		ApiUserBean user = null;
		if ((user = isUserExsit(session))==null) {
			user = new ApiUserBean();
			user.setApi_platform(api_platform);
			user.setFace(face);
			user.setAccess_token(access_token);
			user.setLastLoginTime(System.currentTimeMillis() / 1000);
			user.setNickname(nickname);
			user.setOpenid(openid);
			user.setSex(sex);
			session.save(user);
		}
		try {
			transaction.commit();
			//保存登录的session与用户的token
			HttpSession httpSession = (HttpSession) ServletActionContext.getRequest().getSession();
			httpSession.setMaxInactiveInterval(24*60*60*1000);//设置session过期时间
			userSession.put("user", user);
			userSession.put("token", Base64Utils.encode(openid+access_token));
			
			this.result = ResponseJsonResult.getResponseStateJsonResult("apiLogin", StateMessageKeyEnum.SUCCESS);
			Map<String, Object> data = ResponseJsonResult.getDataMap(result);
			data.clear();
			data.put("token", Base64Utils.encode(openid+access_token));
		} catch (Exception e) {
			this.result = ResponseJsonResult.getResponseStateJsonResult("apiLogin", StateMessageKeyEnum.ERROR);
			Map<String, Object> data = ResponseJsonResult.getDataMap(result);
			data.clear();
		}
		return JSON;
	}

	/**
	 * 判断用户是否已经存在，不存在则保存到数据库 否则返回登录成功, 后台应该与第三方后台接入，这里就不写了
	 * 
	 * @return
	 */
	private ApiUserBean isUserExsit(Session session) {
		List<ApiUserBean> beanList = session.createQuery(
				"from ApiUserBean where openid=:openid and access_token=:access_token and api_platform=:api_platform")
				.setParameter("openid", openid).setParameter("access_token", access_token)
				.setParameter("api_platform", api_platform).list();
		if (beanList == null || beanList.size() == 0)
			return null;
		return beanList.get(0);
	}

	@Override
	protected String setCurrentActionUrl() {
		return "/UserLoginAction";
	}

	@Override
	public void setSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

}
