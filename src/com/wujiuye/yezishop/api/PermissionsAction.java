package com.wujiuye.yezishop.api;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.wujiuye.yezishop.bean.ApiUserBean;
import com.wujiuye.yezishop.utils.StringUtils;


/**
 * 需要权限的action都必须要继承该类
 * @author wjy
 *
 */
public abstract class PermissionsAction extends BaseAction implements SessionAware{

	protected Map<String, Object> userSession;
	
	@Override
	public void setSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	/**
	 * 判断用户是否已经登录
	 * @return
	 */
	protected boolean isLogin(String token) {
		if(StringUtils.isEmpty(token)) {
			return false;
		}
		if(token.equals(userSession.get("token").toString())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取登录的用户
	 * @return
	 */
	protected ApiUserBean getApiLoginUser() {
		if(this.userSession.get("user")==null)
			return null;
		ApiUserBean user = (ApiUserBean) this.userSession.get("user");
		return user;
	}
}
