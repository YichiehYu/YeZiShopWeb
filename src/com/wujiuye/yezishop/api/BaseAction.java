package com.wujiuye.yezishop.api;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {

	public final static String JSON = "JSON";

	protected Map<String, Object> result;// 返回结果
}
