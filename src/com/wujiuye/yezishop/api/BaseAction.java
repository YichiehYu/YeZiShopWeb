package com.wujiuye.yezishop.api;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {

	public final static String JSON = "JSON";

	protected Map<String, Object> result;// 返回结果
	protected String currentActionUrl;
	protected abstract String setCurrentActionUrl();
	public BaseAction() {
		super();
		this.currentActionUrl = this.setCurrentActionUrl();
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	/**
	 * 获取当前请求url
	 * @return
	 */
	protected String getCurrentRequestUrl(String method) {
		return this.currentActionUrl+method;
	}
}
