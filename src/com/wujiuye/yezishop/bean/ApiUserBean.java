package com.wujiuye.yezishop.bean;

import java.io.Serializable;

/**
 * 第三方登录的用户表
 * 
 * @author wjy
 *
 */
public class ApiUserBean implements Serializable {

	private int id;
	private String openid;// 第三方opendid
	private String nickname;// 第三方昵称
	private String face;// 第三方获取的头像
	private int sex;// 性别,0为男1为女
	private String access_token;// 第三方获取的access_token
	private String api_platform;// 那个平台:"QQ","WEIXIN"
	private long lastLoginTime;// 上一次登录时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
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

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
